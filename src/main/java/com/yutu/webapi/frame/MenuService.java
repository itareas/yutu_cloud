package com.yutu.webapi.frame;

import com.yutu.entity.MsgPack;
import com.yutu.entity.TokenInfo;
import com.yutu.service.frame.IPowerService;
import com.yutu.utils.frame.TokenManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    private IPowerService iPowerService;
    @Resource
    HttpServletRequest request;

    /**
    * @Author: zhaobc
    * @Date: 2019-12-23 14:09
    * @Description: 获得菜单列表信息
    **/
    @PUT
    @Path(value = "business")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack business(@QueryParam("token") String token) {
        MsgPack msgPack =new MsgPack();
        if (TokenManager.verificationToken(token, TokenManager.getSecurity(request))) {
            //获得用户角色
            TokenInfo tokenInfo = TokenManager.getTokenInfoById(token, TokenManager.getSecurity(request));
            //查询菜单列表
            msgPack = iPowerService.getBusinessMenuList(tokenInfo.getRoleId());
        }
        return msgPack;
    }
}
