package com.yutu.service.frame.impl;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.MsgPack;
import com.yutu.entity.MsgStatus;
import com.yutu.entity.TokenInfo;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.mapper.frame.*;
import com.yutu.service.frame.ILoginService;
import com.yutu.utils.frame.SessionUserManager;
import com.yutu.utils.frame.TokenManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName:LoginServiceImpl
 * @Author:zhaobc
 * @Date:2019/4/16 11:56
 * @Description:登录服务实现层
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    @Resource
    private TSysUserMapper sysUserMapper;
    @Resource
    private TLogLandingMapper logLandingMapper;
    @Resource
    private TMenuSystemMapper tMenuSystemMapper;
    @Resource
    private TMenuBusinessMapper tMenuBusinessMapper;
    @Resource
    private TBasAppMapper tBasAppMapper;
    @Resource
    private SessionUserManager sessionUserManager;
    @Resource
    private HttpServletRequest request;


    @Override
    public MsgPack getLoginVerification(String userAccount, String userPwd) {
        MsgPack msgPack = new MsgPack();
        //给密码md5加密
        userPwd = DigestUtils.md5Hex(userPwd + "cloud&Zhaobc@2019");
        Map<String, String> userInfo = sysUserMapper.getLoginVerification(userAccount, userPwd);

        //获得客户端身份信息便于验证
        String address = request.getServletPath();
        String ip = request.getRemoteAddr();
        // sesson中存储客户端标识字段，需要进行验证是否是登陆着
        String security = TokenManager.getSecurity(request);

        //日志实体类 并赋值
        TLogLanding landing = new TLogLanding();
        landing.setUuid(UUID.randomUUID().toString());
        landing.setLoginAddress(address);
        landing.setLoginAccount(userAccount);
        landing.setLoginDate(new Date());
        landing.setLoginIp(ip);
        landing.setLoginType("门户登陆");
        landing.setLoginAppname("系统门户网站");
        HttpSession session = request.getSession();
        //判断登录是否成功
        if (userInfo != null) {
            //获得菜单列表
            List<TMenuSystem> listMenuSys = tMenuSystemMapper.getRoleMenuSys(userInfo.get("role_uuid"));
            List<TMenuBusiness> listMenuBus = new ArrayList<>();
            if (SystemPropertiesConfig.System_LoginStorage_Type.equals("redis")) {
                listMenuBus = tMenuBusinessMapper.getRoleMenuBus(userInfo.get("role_uuid"));
            }
            //session存储用户信息操作
            msgPack = sessionUserManager.setSessionUser(session.getId(), security, userInfo, listMenuSys, listMenuBus);
            //记录日志
            landing.setLoginUserid(userInfo.get("uuid"));
            landing.setLoginSessionid(session.getId());
            landing.setLoginResult(msgPack.getStatus());
        }

        //数据库存储登录日志
        int landingCount = logLandingMapper.insert(landing);
        System.out.print("=============================>" + msgPack.getMsg() + "门户登陆日志插入" + landingCount + "条-------------------------------\r\n");

        return msgPack;
    }

    @Override
    public MsgPack getAuthPwdLogin(String userAccount, String userPwd) {
        MsgPack msgPack = new MsgPack();
        //验证用户密码
        Map<String, String> userInfo = sysUserMapper.getLoginVerification(userAccount, userPwd);
        if (userInfo != null && userInfo.size() > 0) {
            msgPack.setStatus(1);
            msgPack.setData(userInfo);
        }
        return msgPack;
    }

    @Override
    public MsgPack getAuthSSOLogin(String token) {
        MsgPack msgPack = new MsgPack();
        //验证token是否过期
        TokenInfo tokenInfo = TokenManager.getTokenInfoById(token, request.getRemoteAddr());
        if (tokenInfo != null) {
            msgPack.setStatus(MsgStatus.SUCCESS.getCode());
            msgPack.setData(tokenInfo.getApiUser());
        }
        //返回用户信息
        return msgPack;
    }

    @Override
    public MsgPack getTokenByAppkey(String appKey) {
        MsgPack msgPack = new MsgPack();
        //验证appkey
        int appCount = tBasAppMapper.getAppCount(appKey);
        if (appCount < 1) {
            msgPack.setMsg("该appKey不正确，请联系管理员重新申请！");
            return msgPack;
        }
        //插入token值
        TokenInfo tokenInfo = new TokenInfo();
        String tokenId = UUID.randomUUID().toString();
        // 获得过期时间
        String expirationDate = SystemPropertiesConfig.System_Token_TimeOut;
        SimpleDateFormat sdf = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");// 设置日期格式
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.SECOND, Integer.parseInt(expirationDate) * 24);
        tokenInfo.setToken(tokenId);
        tokenInfo.setAppkey(appKey);
        tokenInfo.setSecurity(TokenManager.getSecurity(request));
        tokenInfo.setExpirationDate(nowTime.getTime());
        //put token值
        TokenManager.putToken(tokenInfo);
        //设置返回参数
        Map<String, String> mapData = new HashMap<>();
        mapData.put("token", tokenId);
        mapData.put("expire", sdf.format(nowTime.getTime()));
        msgPack.setStatus(MsgStatus.SUCCESS.getCode());
        msgPack.setData(mapData);
        return msgPack;
    }
}
