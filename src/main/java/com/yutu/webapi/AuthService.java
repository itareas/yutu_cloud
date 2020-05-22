package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.service.ILoginService;
import com.yutu.utils.TokenManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:认证服务接口服务 restful
 */
@Component
@Path("auth")
public class AuthService {
    @Resource
    private ILoginService loginService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 15:27
     * @Description: 对外普通密码登录
     **/
    @PUT
    @Path(value = "login")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack login(@QueryParam("userAccount") String userAccount, @QueryParam("userPwd") String userPwd) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthPwdLogin(userAccount, userPwd);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 16:00
     * @Description:对外单点登录
     **/
    @PUT
    @Path(value = "sso")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack loginSSO(@QueryParam("appkey") String appkey, @QueryParam("token") String token) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(appkey, token);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:51
     * @Description: 验证token 无需apk
     **/
    @PUT
    @Path(value = "token")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack token(@QueryParam("token") String token) {
        MsgPack msgPack = new MsgPack();
        if (TokenManager.verificationToken(token)) {
            msgPack.setStatus(1);
        } else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }


}
