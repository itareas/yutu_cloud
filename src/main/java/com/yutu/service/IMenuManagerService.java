package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;

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

    MsgPack getMenuSysList(int pageIndex,int pageSize);

    MsgPack getMenuBusList(int pageIndex,int pageSize);

    MsgPack getMenuSysInsertById(TMenuSystem menuSystem);

    MsgPack getMenuBusInsertById(TMenuBusiness menuBusiness);

    MsgPack getMenuSysDelById(String id);

    MsgPack getMenuBusDelById(String id);

    MsgPack getMenuSysUpdateById(String id,TMenuSystem menuSystem);

    MsgPack getMenuBusUpdateById(String id,TMenuBusiness menuBusiness);

    MsgPack getMenuSysInfoById(String id);

    MsgPack getMenuBusInfoById(String id);
}
