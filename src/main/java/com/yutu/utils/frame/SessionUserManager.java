package com.yutu.utils.frame;

import com.alibaba.fastjson.JSON;
import com.yutu.configuration.SystemCoreConfig;
import com.yutu.entity.MsgPack;
import com.yutu.entity.MsgStatus;
import com.yutu.entity.SessionUser;
import com.yutu.entity.TokenInfo;
import com.yutu.entity.api.ApiUser;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.service.frame.IPowerService;
import com.yutu.utils.database.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 11:13
 * @Description:session获取管理类 自己用
 */
@Component
public class SessionUserManager {
    @Resource
    private RedisUtils redisUtils;

    @Resource
    private IPowerService logManagerService;

    @Resource
    HttpServletRequest request;

    private final Logger logger = LoggerFactory.getLogger(SessionUserManager.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/12/22 10:08
     * @Description: 验证session是否有效
     **/
    public MsgPack verificationSessionUser() {
        MsgPack msgPack = new MsgPack();
        SessionUser sessionUser = getSessionUser();
        if (sessionUser != null) {
            //增加延迟时间
            msgPack = expireSessionUser(sessionUser);
        }
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/12/22 9:42
     * @Description: 获得session信息
     **/
    public SessionUser getSessionUser() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String sessionId = session.getId().toLowerCase();
            //判断用户登陆存储方式
            switch (SystemCoreConfig.System_LoginStorage_Type) {
                case "session":
                    if (sessionId != null) {
                        //Session版获取数据
                        SessionUser sessionUser = (SessionUser) session.getAttribute("cloud-zbc" + sessionId);
                        return sessionUser;
                    }
                    break;
                case "redis":
                    if (sessionId != null) {
                        SessionUser sessionUser = (SessionUser) redisUtils.get("cloud-zbc" + sessionId);
                        return sessionUser;
                    }
                    break;
                default:
                    if (sessionId != null) {
                        //Session版获取数据
                        SessionUser sessionUser = (SessionUser) session.getAttribute("cloud-zbc" + sessionId);
                        return sessionUser;
                    }
                    break;
            }
        }
        return null;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/12/22 9:42
     * @Description: 存储Session信息
     **/
    public MsgPack setSessionUser(String sessionId, String security, Map<String, String> userInfo, List<TMenuSystem> listMenuSys, List<TMenuBusiness> listMenuBus) {
        MsgPack msgPack = new MsgPack();
        //设置sessionUser值
        SessionUser sessionUser = new SessionUser();
        sessionUser.setSessionId("cloud-zbc" + sessionId.toLowerCase());
        sessionUser.setUuid(userInfo.get("uuid"));
        sessionUser.setUserAccount(userInfo.get("user_account"));
        sessionUser.setUserName(userInfo.get("user_name"));
        sessionUser.setUserSafety(security);
        sessionUser.setRoleId(userInfo.get("role_uuid"));
        sessionUser.setOrgId(userInfo.get("org_uuid"));
        sessionUser.setMenuSys(JSON.toJSONString(listMenuSys));
        sessionUser.setMenuBus(JSON.toJSONString(listMenuBus));
        //判断session
        HttpSession session = request.getSession(false);
        //判断是ses否为空
        if (session != null && sessionId.length() > 0) {
//            if (session.isNew()) {
            switch (SystemCoreConfig.System_LoginStorage_Type) {
                case "session":
                    //设置对外tokenId到Session中
                    String tokenId = "cloud-zbc" + UUID.randomUUID().toString();
                    sessionUser.setToken(tokenId);
                    //存储到session中去 并设置超时时间
                    request.getSession().setAttribute(sessionUser.getSessionId(), sessionUser);
                    request.getSession().setMaxInactiveInterval(Integer.parseInt(SystemCoreConfig.System_Token_TimeOut));
                    msgPack.setStatus(MsgStatus.SUCCESS.getCode());

                    //设置对外接口参数
                    TokenInfo tokenInfo = new TokenInfo();
                    tokenInfo.setToken(tokenId);
                    tokenInfo.setRoleId(userInfo.get("role_uuid"));

                    // 获得过期时间
                    String expirationDate = SystemCoreConfig.System_Token_TimeOut;
                    SimpleDateFormat sdf = new SimpleDateFormat(
                            "yyyy-MM-dd HH:mm:ss");// 设置日期格式
                    Calendar nowTime = Calendar.getInstance();
                    nowTime.add(Calendar.MINUTE,
                            Integer.parseInt(expirationDate));
                    tokenInfo.setExpirationDate(nowTime.getTime());
                    //设置用户信息
                    ApiUser apiUser = new ApiUser();
                    apiUser.setUuid(userInfo.get("uuid"));
                    apiUser.setUserAccount(userInfo.get("user_account"));
                    apiUser.setUserEmail(userInfo.get("user_email"));
                    apiUser.setUserCode(userInfo.get("user_code"));
                    apiUser.setUserName(userInfo.get("user_name"));
                    apiUser.setUserPhone(userInfo.get("user_phone"));
                    apiUser.setUserSex(String.valueOf(userInfo.get("user_sex")));
                    apiUser.setUserTitle(userInfo.get("user_title"));
                    tokenInfo.setApiUser(apiUser);
                    tokenInfo.setSecurity(security);
                    //设置token
                    TokenManager.putToken(tokenInfo);
                    break;
                case "redis":
                    //存储到redis
                    sessionUser.setToken(sessionUser.getSessionId());
                    redisUtils.set(sessionUser.getSessionId(), sessionUser, Long.parseLong(SystemCoreConfig.System_Token_TimeOut));
                    msgPack.setStatus(MsgStatus.SUCCESS.getCode());
                    break;
            }
//            } else {
//                //session有值，不在存储
//                msgPack.setStatus(1);
//            }
        }
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019/12/22 9:56
     * @Description: 登录成功为存储的session/Redis延长时间
     **/
    public MsgPack expireSessionUser(SessionUser sessionUser) {
        MsgPack msgPack = new MsgPack();
        if (sessionUser != null) {
            switch (SystemCoreConfig.System_LoginStorage_Type) {
                case "session":
                    //存储到session中去
                    request.getSession().setAttribute(sessionUser.getSessionId(), sessionUser);
                    request.getSession().setMaxInactiveInterval(Integer.parseInt(SystemCoreConfig.System_Token_TimeOut));
                    msgPack.setStatus(MsgStatus.SUCCESS.getCode());
                    msgPack.setData(sessionUser);
                    break;
                case "redis":
                    //存储到redis
                    redisUtils.expire(sessionUser.getSessionId(), Long.parseLong(SystemCoreConfig.System_Token_TimeOut));
                    msgPack.setStatus(MsgStatus.SUCCESS.getCode());
                    msgPack.setData(sessionUser);
                    break;
            }
        }
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/1 11:47
     * @Description: 注销session里的值
     **/
    public void logoutSessionUser(HttpSession session) {
        String sessionId = session.getId().toLowerCase();
        //获得参数插入日志
        TLogLanding landing = new TLogLanding();
        SessionUser sessionUser = getSessionUser();
        if (request.getSession(false) != null) {
            if (sessionId != null) {
                landing.setUuid(UUID.randomUUID().toString());
                landing.setLoginUserid(sessionUser.getUuid());
                landing.setLoginAccount(sessionUser.getUserAccount());
                landing.setLoginAddress(request.getServletPath());
                landing.setLoginSessionid(sessionId);
                landing.setLoginDate(new Date());
                landing.setLoginType("门户注销");
                landing.setLoginAppname("系统门户网站");
                landing.setLoginIp(request.getRemoteAddr());
            }
        }
        try {
            //清空本地session
            session.invalidate();
            if (SystemCoreConfig.System_LoginStorage_Type.equals("session")) {
                //删除token值
                TokenManager.deleteTokenById(sessionUser.getToken());
            } else if (SystemCoreConfig.System_LoginStorage_Type.equals("redis")) {
                //清空redis里数据
                redisUtils.del(sessionUser.getSessionId());
            }
        } catch (Exception e) {
            landing.setLoginResult(0);
            landing.setRemarks(e.toString());
        } finally {
            landing.setLoginResult(1);
            //插入日志
            logManagerService.insertLandingLog(landing);
        }
    }
}
