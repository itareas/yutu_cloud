package com.yutu.util;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.TokenInfo;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;

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
    public static TokenInfo getTokenInfoById(String token) {
        if (tokenList.containsKey(token)) {
            return tokenList.get(token);
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 添加会话信息
     **/
    public static void putSession(TokenInfo tokenInfo) {
        if (getTokenInfoById(tokenInfo.getToken()) == null) {
            tokenList.put(tokenInfo.getToken(), tokenInfo);
        }
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 删除会话信息
     **/
    public static void deleteSessionById(String token) {
        tokenList.remove(token);
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:31
     * @Description: 删除所有过期会话信息
     **/
    public static void deleteSessionAll() {
        Iterator<Map.Entry<String, TokenInfo>> mapToken = tokenList
                .entrySet().iterator();
        while (mapToken.hasNext()) {
            Map.Entry<String, TokenInfo> entryToken = mapToken.next();
            if (!verificationToken(entryToken.getKey())) {
                mapToken.remove();
            }
        }
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:32
     * @Description: 验证token是否有效
     **/
    public static Boolean verificationToken(String token) {
        TokenInfo tokenInfo = TokenManager.getTokenInfoById(token);
        if (tokenInfo != null) {
            Date tokenDate = tokenInfo.getExpirationDate();
            Date now = new Date();
            if (now.getTime() < tokenDate.getTime()) {
                // 获得过期时间  增加时间段
                String expirationDate = SystemPropertiesConfig.System_Token_TimeOut;
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 设置日期格式
                Calendar nowTime = Calendar.getInstance();
                nowTime.add(Calendar.MINUTE,
                        Integer.parseInt(expirationDate));
                tokenInfo.setExpirationDate(nowTime.getTime());
                TokenManager.putSession(tokenInfo);
                return true;
            }
        }
        return false;
    }
}
