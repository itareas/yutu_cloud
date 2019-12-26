package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.api.ApiAuth;
import com.yutu.service.ILoginService;
import com.yutu.util.TokenManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:认证服务接口服务
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
    @Path(value = "login")
    @POST
    @Produces("applications/json")
    public MsgPack login(@FormParam("userAccount") String userAccount, @FormParam("userPwd")  String userPwd) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthPwdLogin(userAccount, userPwd);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 16:00
     * @Description:对外单点登录
     **/
    @Path(value = "loginSSO")
    @POST
    @Produces("applications/json")
    public MsgPack loginSSO(@BeanParam ApiAuth json) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(json.getAPPKEY(), json.getTOKEN());
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 18:51
     * @Description: 验证token 无需apk
     **/
    @Path(value = "token")
    @GET
    @Produces("applications/json")
    public MsgPack token(@FormParam("token") String token) {

        MsgPack msgPack = new MsgPack();
        if (TokenManager.verificationToken(token)) {
            msgPack.setStatus(1);

        } else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }



}
