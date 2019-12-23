package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.api.ApiAuth;
import com.yutu.service.IMenuManagerService;
import com.yutu.util.SessionUserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 18:53
 * @Description:
 */
@RestController
@RequestMapping("/api/menu")
public class MenuService {
    @Resource
    private SessionUserManager  sessionUserManager;

    @Resource
    private IMenuManagerService menuManagerService;

    /**
    * @Author: zhaobc
    * @Date: 2019-12-23 14:09
    * @Description: 获得菜单列表信息
    **/
    @RequestMapping(value = "/business")
    @ResponseBody
    public MsgPack business(ApiAuth json) {
        MsgPack msgPack =new MsgPack();
        //获得用户角色
        SessionUser sessionUser =sessionUserManager.getSessionUser();
        //查询菜单列表
        msgPack=menuManagerService.getBusinessMenuList(sessionUser.getRoleId());
        return msgPack;
    }
}
