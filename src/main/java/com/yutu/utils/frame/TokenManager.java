package com.yutu.utils.frame;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.TokenInfo;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 18:25
 * @Description:Token通用管理类
 */
public class TokenManager {
    private static HashMap<String, TokenInfo> tokenList = new HashMap<String, TokenInfo>();

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 根据回话id，查询token信息
     **/
    public static TokenInfo getTokenInfoById(String token, String security) {
        if (verificationToken(token, security)) {
            return tokenList.get(token);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 添加会话信息
     **/
    public static void putToken(TokenInfo tokenInfo) {
        if (!tokenList.containsKey(tokenInfo.getToken())) {
            tokenList.put(tokenInfo.getToken(), tokenInfo);
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 删除会话信息
     **/
    public static void deleteTokenById(String token) {
        tokenList.remove(token);
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/9/18 14:15
     * @Description: 处理保护措施的码
     **/
    public static String getSecurity(HttpServletRequest request) {
        //获得客户端身份信息便于验证
        String security = request.getRemoteAddr() + "<yutu_frame>" + request.getHeader("User-Agent");
        // sesson中存储客户端标识字段，需要进行验证是否是登陆着
        return security;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 删除所有过期会话信息
     **/
    public static void deleteTokenAll() {
        Iterator<Map.Entry<String, TokenInfo>> mapToken = tokenList.entrySet().iterator();
        while (mapToken.hasNext()) {
            Map.Entry<String, TokenInfo> entryToken = mapToken.next();
            if (!verificationToken(entryToken.getKey(), entryToken.getValue().getSecurity())) {
                mapToken.remove();
            }
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:32
     * @Description: 验证token是否有效
     **/
    public static Boolean verificationToken(String token, String security) {
        TokenInfo tokenInfo = tokenList.get(token);
        if (tokenInfo != null && security != null) {
            Date tokenDate = tokenInfo.getExpirationDate();
            Date now = new Date();
            if (now.getTime() < tokenDate.getTime()) {
                // 获得过期时间  增加时间段 接口过期为0.5*24=12小时
                String expirationDate = SystemPropertiesConfig.System_Token_TimeOut;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
                Calendar nowTime = Calendar.getInstance();
                nowTime.add(Calendar.SECOND, Integer.parseInt(expirationDate) * 24);
                tokenInfo.setExpirationDate(nowTime.getTime());
                TokenManager.putToken(tokenInfo);
                return true;
            }
        }
        return false;
    }
}
