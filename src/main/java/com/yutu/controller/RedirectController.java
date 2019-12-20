package com.yutu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName:RedirectController
 * @Author:zhaobc
 * @Date:2019/4/16 11:48
 * @Description:全局通用跳转页
 **/
@Controller
public class RedirectController {

    /**
     * @Author:zhaobc
     * @Date:2019/4/16 11:50
     * @Description:登录页
     **/
    @RequestMapping("/")
    public String login() {
        return "login";
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:05
     * @Description: 单点登录地址
     **/
    @RequestMapping(value = "/loginSSO")
    public void loginSSO(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index");
    }

    /**
     * @Author:zhaobc
     * @Date:2019/4/16 11:50
     * @Description:系统首页
     **/
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
