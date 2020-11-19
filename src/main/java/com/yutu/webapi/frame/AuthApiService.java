package com.yutu.webapi.frame;

import com.yutu.entity.MsgPack;
import com.yutu.entity.MsgStatus;
import com.yutu.service.frame.ILoginService;
import com.yutu.utils.frame.TokenManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:认证服务接口服务 restful
 */
@Component
@Path("auth")
public class AuthApiService {
    @Resource
    private ILoginService loginService;
    @Resource
    HttpServletRequest request;
    @Resource
    HttpServletResponse response;

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
    public MsgPack loginSSO(@QueryParam("token") String token) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(token);
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
        if (TokenManager.verificationToken(token, TokenManager.getSecurity(request))) {
            msgPack.setStatus(MsgStatus.SUCCESS.getCode());
        } else {
            msgPack.setStatus(MsgStatus.FAIL.getCode());
        }
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/7/27 18:04
     * @Description: 验证appkey获得tokey
     **/
    @POST
    @Path(value = "gettoken")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack gettoken(@FormParam("appkey") String appkey) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getTokenByAppkey(appkey);
        return msgPack;
    }
}
