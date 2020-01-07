package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.service.ILoginService;
import com.yutu.util.CaptchaUtils;
import com.yutu.util.SessionUserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        String userAccount = request.getParameter("userAccount");
        String userPwd = request.getParameter("userPwd");
        MsgPack msgPak = loginService.getLoginVerification(userAccount, userPwd);
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
    public void captchato(HttpServletRequest request, HttpServletResponse response, HttpSession session, String timestamp) throws IOException, java.io.IOException {
        //response.setHeader("Content-Security-Policy", "script-src 'self'; object-src 'none'; style-src cdn.example.org third-party.org;");
        CaptchaUtils.outputCaptcha(request, response);
    }

    @RequestMapping(value ="/check")
    public String check(String yanzhengma, HttpSession session) {
        String verification = "";
        char[] arr = yanzhengma.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 'a') && (arr[i] <= 'z')) {
                int tmpVer = i;
                char[] tmpVers = arr;
                tmpVers[tmpVer] = ((char) (tmpVers[tmpVer] - ' '));
            }
        }
        String string = new String(arr);
        String validateCode = (String) session.getAttribute("randomString");
        if (validateCode.equals(string))
            verification = "true";
        else {
            verification = "false";
        }
        return verification;
    }
}
