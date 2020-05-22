package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.TokenInfo;
import com.yutu.service.ILoginService;
import com.yutu.service.IMenuManagerService;
import com.yutu.utils.TokenManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 18:53
 * @Description:
 */
@Component
@Path("menu")
public class MenuService {

    @Resource
    private ILoginService loginService;

    @Resource
    private IMenuManagerService menuManagerService;

    /**
    * @Author: zhaobc
    * @Date: 2019-12-23 14:09
    * @Description: 获得菜单列表信息
    **/
    @PUT
    @Path(value = "business")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack business(@QueryParam("appkey") String appkey, @QueryParam("token") String token) {
        MsgPack msgPack =new MsgPack();
        msgPack = loginService.getAuthSSOLogin(appkey, token);
        if (msgPack.getStatus() == 1) {
            //获得用户角色
            TokenInfo tokenInfo = TokenManager.getTokenInfoById(token);
            //查询菜单列表
            msgPack = menuManagerService.getBusinessMenuList(tokenInfo.getRoleId());
        }
        return msgPack;
    }
}
