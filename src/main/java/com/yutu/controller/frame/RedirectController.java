package com.yutu.controller.frame;

import com.yutu.entity.SessionUser;
import com.yutu.utils.frame.SessionUserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName:RedirectController
 * @Author:zhaobc
 * @Date:2019/4/16 11:48
 * @Description:全局通用跳转页
 **/
@Controller
public class RedirectController {
    @Resource
    private SessionUserManager sessionUserManager;

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
     * @Author:zhaobc
     * @Date:2019/4/16 11:50
     * @Description:系统首页
     **/
    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        SessionUser sessionUser = sessionUserManager.getSessionUser();
        String userName = "";
        if (sessionUser != null) {
            userName = sessionUser.getUserName();
        }
        modelMap.put("userName", userName);
        return "index/index";
    }


    /**
    * @Author: zhaobc
    * @Date: 2020/1/12 16:10
    * @Description: 系统管理
    **/
    @RequestMapping("/management")
    public String management() {
        return "management/index";
    }

}
