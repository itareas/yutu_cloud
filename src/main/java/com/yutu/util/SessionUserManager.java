package com.yutu.util;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.filter.MyFilter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 11:13
 * @Description:session获取管理类
 */
@Component
public class SessionUserManager {
    @Resource
    private RedisUtils redisUtils;

    @Resource
    HttpServletRequest request;

    Logger logger = Logger.getLogger(SessionUserManager.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/12/22 10:08
     * @Description: 验证session是否有效
     **/
    public MsgPack verificationSessionUser() {
        MsgPack  msgPack =new MsgPack();
        msgPack.setStatus(0);
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
            //判断用户登陆存储方式
            switch (SystemPropertiesConfig.System_LoginStorage_Type) {
                case "session":
                    if (session.getId() != null) {
                        //Session版获取数据
                        SessionUser sessionUs = (SessionUser) session.getAttribute(session.getId());
                        return sessionUs;
                    }
                    break;
                case "redis":
                    //判断是单点登录还是普通登录
                    if (SystemPropertiesConfig.System_Login_Type.equals("SSO")) {
                        String token = request.getSession().getAttribute(SystemPropertiesConfig.System_Auth_Token).toString();
                        SessionUser sessionUser = (SessionUser) redisUtils.get(token);
                        return sessionUser;
                    } else {
                        if (session.getId() != null) {
                            SessionUser sessionUser = (SessionUser) redisUtils.get(session.getId());
                            return sessionUser;
                        }
                    }
                    break;
                default:
                    if (session.getId() != null) {
                        //Session版获取数据
                        SessionUser sessionUser = (SessionUser) session.getAttribute(session.getId());
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
    public MsgPack setSessionUser(SessionUser sessionUser) {
        MsgPack msgPack = new MsgPack();
        msgPack.setStatus(0);
        //判断session
        HttpSession session = request.getSession(false);
        //判断是ses否为空
        if (session != null && sessionUser != null && sessionUser.getSessionId().length() > 0) {
            if (session.isNew()) {
                switch (SystemPropertiesConfig.System_LoginStorage_Type) {
                    case "session":
                        //存储到session中去 并设置超时时间
                        request.getSession().setAttribute(sessionUser.getSessionId(), sessionUser);
                        request.getSession().setMaxInactiveInterval(Integer.parseInt(SystemPropertiesConfig.System_Token_TimeOut));
                        msgPack.setStatus(1);
                        break;
                    case "redis":
                        //存储到redis
                        redisUtils.set(session.getId(), sessionUser, Long.parseLong(SystemPropertiesConfig.System_Token_TimeOut));
                        msgPack.setStatus(1);
                        break;
                    default:
                        //存储到session中去
                        request.getSession().setAttribute(sessionUser.getSessionId(), sessionUser);
                        request.getSession().setMaxInactiveInterval(Integer.parseInt(SystemPropertiesConfig.System_Token_TimeOut));
                        msgPack.setStatus(1);
                        break;
                }
            }
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
        msgPack.setStatus(0);
        if (sessionUser != null) {
            switch (SystemPropertiesConfig.System_LoginStorage_Type) {
                case "session":
                    //存储到session中去
                    request.getSession().setAttribute(sessionUser.getSessionId(), sessionUser);
                    request.getSession().setMaxInactiveInterval(Integer.parseInt(SystemPropertiesConfig.System_Token_TimeOut));
                    msgPack.setStatus(1);
                    msgPack.setData(sessionUser);
                    break;
                case "redis":
                    //存储到redis
                    redisUtils.expire(sessionUser.getSessionId(), Long.parseLong(SystemPropertiesConfig.System_Token_TimeOut));
                    msgPack.setStatus(1);
                    msgPack.setData(sessionUser);
                    break;
            }
        }
        return msgPack;
    }
}
