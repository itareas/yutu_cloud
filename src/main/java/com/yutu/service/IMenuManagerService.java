package com.yutu.service;

import com.yutu.entity.MsgPack;

/**
 * @Author: zhaobc
 * @Date: 2019-12-23 14:14
 * @Description: 菜单操作类接口
 */
public interface IMenuManagerService {

    /**
    * @Author: zhaobc
    * @Date: 2019-12-23 14:23
    * @Description: 获得业务菜单列表
    **/
    MsgPack getBusinessMenuList(String roleId);
}
