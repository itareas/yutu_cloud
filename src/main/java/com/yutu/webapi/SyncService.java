package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.service.IOrganizationManagerService;
import com.yutu.service.IUserManagerService;
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
    private IUserManagerService iUserService;
    @Resource
    private IOrganizationManagerService iOrganizationService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:01
     * @Description: 同步用户接口
     **/
    @PostMapping("/user")
    @ResponseBody
    public MsgPack user(int type) {
        MsgPack msgPack = new MsgPack();
        switch (type) {
            case 1:
//                推送新增用户

                break;
            case 2:
//                推送修改用户

                break;
            case 3:
//                推送删除用户

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
    public MsgPack organize(int type) {
        MsgPack msgPack = new MsgPack();
        switch (type) {
            case 1:
//                推送添加部门

                break;
            case 2:
//                推送修改部门

                break;
            case 3:
//                推送删除删除

                break;
        }
        return msgPack;
    }
}
