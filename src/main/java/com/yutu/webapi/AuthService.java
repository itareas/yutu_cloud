package com.yutu.webapi;

import com.alibaba.fastjson.JSON;
import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TLogLanding;
import com.yutu.service.ILoginService;
import com.yutu.util.TokenManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:认证服务接口服务
 */
@RestController
@RequestMapping("/auth")
public class AuthService {
    @Resource
    private ILoginService loginService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 15:27
     * @Description: 对外普通密码登录
     **/
    @RequestMapping(value = "/login")
    @ResponseBody
    public MsgPack login(String userAccount, String userPwd) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthPwdLogin(userAccount, userPwd);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 16:00
     * @Description:对外单点登录
     **/
    @RequestMapping(value = "/loginSSO")
    @ResponseBody
    public MsgPack loginSSO(String appkey, String token) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(appkey, token);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:51
     * @Description: 验证token
     **/
    @RequestMapping(value = "/verificationToken")
    @ResponseBody
    public MsgPack verificationToken(String token) {
        MsgPack msgPack = new MsgPack();
        if (TokenManager.verificationToken(token)) {
            msgPack.setStatus(1);

        } else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }



}
