package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.service.ILoginService;
import com.yutu.service.IMenuManagerService;
import com.yutu.util.SessionUserManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    private SessionUserManager  sessionUserManager;

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
    public MsgPack business(@QueryParam("APPKEY") String APPKEY, @QueryParam("TOKEN") String TOKEN) {
        MsgPack msgPack =new MsgPack();
        msgPack = loginService.getAuthSSOLogin(APPKEY, TOKEN);
        if (msgPack.getStatus() == 1) {
            //获得用户角色
            SessionUser sessionUser = sessionUserManager.getSessionUser();
            //查询菜单列表
            msgPack = menuManagerService.getBusinessMenuList(sessionUser.getRoleId());
        }
        return msgPack;
    }
}
