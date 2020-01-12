package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.service.ILoginService;
import com.yutu.util.CaptchaUtils;
import com.yutu.util.SessionUserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    private SessionUserManager sessionUserManager;
    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/20 21:55
     * @Description: 用户登录验证
     **/
    @RequestMapping(value = "getLoginVerification")
    public MsgPack getLoginVerification(HttpServletRequest request) {
        MsgPack msgPak = new MsgPack();
        //获取验证码 转小写
        String code = request.getParameter("code").toLowerCase();
        String codeNew=CaptchaUtils.getCaptchas().toLowerCase();
        if (!code.equals(codeNew)) {
            msgPak.setMsg("验证码不正确");
            return msgPak;
        }
        String userAccount = request.getParameter("userAccount");
        String userPwd = request.getParameter("userPwd");
        msgPak = loginService.getLoginVerification(userAccount, userPwd);
        return msgPak;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:46
     * @Description: 注销登录
     **/
    @RequestMapping(value = "logout")
    public void logout() throws IOException {
        HttpSession session = request.getSession();
        sessionUserManager.logoutSessionUser(session);
        //刷新页面
        response.sendRedirect("../");
    }

    @RequestMapping(value = "/captchato")
    public void captchato(HttpServletRequest request, HttpServletResponse response, HttpSession session, String time) throws IOException, java.io.IOException {
        CaptchaUtils.outputCaptcha(request, response);
    }

}
