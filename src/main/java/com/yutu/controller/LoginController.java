package com.yutu.controller;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TLogLanding;
import com.yutu.service.ILogService;
import com.yutu.service.ILoginService;
import com.yutu.util.RedisUtils;
import com.yutu.util.SessionUserUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName:LoginController
 * @Author:zhaobc
 * @Date:2019/4/16 11:51
 * @Description:登录操作控制层
 **/
@RestController
@RequestMapping(value = "login")
public class LoginController {
    @Resource
    private ILoginService loginService;
    @Resource
    private ILogService logService;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private SessionUserUtils sessionUserUtils;
    /**
     * @Author: zhaobc
     * @Date: 2019/4/20 21:55
     * @Description: 用户登录验证
     **/
    @RequestMapping(value = "getLoginVerification")
    public MsgPack getLoginVerification(HttpServletRequest request) {
        String userAccount = request.getParameter("userAccount");
        String userPwd = request.getParameter("userPwd");
        MsgPack msgPak = loginService.getLoginVerification(request, userAccount, userPwd);
        return msgPak;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:46
     * @Description: 注销登录
     **/
    @RequestMapping(value = "logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        //获得参数插入日志
        TLogLanding landing = new TLogLanding();
        if (request.getSession(false) != null) {
            if (sessionId != null) {
                SessionUser sessionUser = sessionUserUtils.getSessionUser(request);
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
            //清空redis里数据
            redisUtils.del(sessionId);
            //清空本地session
            session.invalidate();
        } catch (Exception e) {
            landing.setLoginResult(0);
            landing.setRemarks(e.toString());
        } finally {
            landing.setLoginResult(1);
            //插入日志
            logService.insertLandingLog(landing);
            //刷新页面
            response.sendRedirect("../login");
        }
    }
}
