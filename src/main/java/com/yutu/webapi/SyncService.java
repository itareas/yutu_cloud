package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.sync.SyncOrganization;
import com.yutu.entity.sync.SyncUser;
import com.yutu.service.IOrganizationService;
import com.yutu.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:56
 * @Description:数据同步接口服务 调用子系统
 */
@RestController
@RequestMapping("/api/sync")
public class SyncService {
    @Resource
    private IUserService iUserService;
    @Resource
    private IOrganizationService iOrganizationService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:01
     * @Description: 同步用户接口
     **/
    @PostMapping("/user")
    @ResponseBody
    public MsgPack user(SyncUser user) {
        MsgPack msgPack = new MsgPack();
        switch (user.getType()) {
            case 1:
//                添加用户
                msgPack = iUserService.insertUser(user);
                break;
            case 2:
//                修改用户
                msgPack = iUserService.updateUser(user);
                break;
            case 3:
//                删除用户
                msgPack = iUserService.delteUser(user.getUuid());
                break;
        }
        return msgPack;
    }


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:01
     * @Description: 同步用户接口
     **/
    @PostMapping("/organize")
    @ResponseBody
    public MsgPack organize(SyncOrganization organization) {
        MsgPack msgPack = new MsgPack();
        switch (organization.getType()) {
            case 1:
//                添加部门
                msgPack = iOrganizationService.insertOrganization(organization);
                break;
            case 2:
//                修改部门
                msgPack = iOrganizationService.updateOrganization(organization);
                break;
            case 3:
//                删除删除
                msgPack = iOrganizationService.delteOrganization(organization.getUuid());
                break;
        }
        return msgPack;
    }
}
