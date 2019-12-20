package com.yutu.util;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.SessionUser;
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

    public  SessionUser getSessionUser(HttpServletRequest request) {
        SessionUser sessionUser = new SessionUser();
        HttpSession session = request.getSession(false);
        //判断用户登陆存储方式
        switch (SystemPropertiesConfig.System_LoginStorage_Type) {
            case "session":
                if (session != null) {
                    if (session.getId() != null) {
                        //Session版获取数据
                        sessionUser = (SessionUser) session.getAttribute(session.getId());
                    }
                }
                break;
            case "redis":
                if (session != null) {
                    if (session.getId() != null) {
                        sessionUser = (SessionUser) redisUtils.get(session.getId());
                    }
                }
                break;
            default:
                if (session != null) {
                    if (session.getId() != null) {
                        //Session版获取数据
                        sessionUser = (SessionUser) session.getAttribute(session.getId());
                    }
                }
                break;
        }
        return sessionUser;
    }
}
