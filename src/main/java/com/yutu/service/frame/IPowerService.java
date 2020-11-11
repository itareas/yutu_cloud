package com.yutu.service.frame;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.*;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:31
 * @Description:权限业务操作层
 */
public interface IPowerService {
    /**
     * @Author: zhaobc
     * @Date: 2019/4/21 17:32
     * @Description: 插入登陆日志
     **/
    MsgPack insertLandingLog(TLogLanding landing);


    /**
     * @Author: zhaobc
     * @Date: 2019/4/21 17:32
     * @Description: 插入登陆日志
     **/
    MsgPack insertOperationLog(TLogOperation operation);

    MsgPack getBusinessMenuList(String roleId);

    MsgPack getMenuSysList(int pageIndex, int pageSize);

    MsgPack getMenuBusList(int pageIndex, int pageSize);

    MsgPack getMenuSysInsertById(TMenuSystem menuSystem);

    MsgPack getMenuBusInsertById(TMenuBusiness menuBusiness);

    MsgPack getMenuSysDelById(String id);

    MsgPack getMenuBusDelById(String id);

    MsgPack getMenuSysUpdateById(String id, TMenuSystem menuSystem);

    MsgPack getMenuBusUpdateById(String id, TMenuBusiness menuBusiness);

    MsgPack getMenuSysInfoById(String id);

    MsgPack getMenuBusInfoById(String id);

    MsgPack getLogLandingList(int pageIndex, int pageSize);

    MsgPack getLogOperationList(int pageIndex, int pageSize);

    MsgPack getLogErrorList(int pageIndex, int pageSize);

    MsgPack getLogLandingDelById(String id);

    MsgPack getLogOperationDelById(String id);

    MsgPack getLogErrorDelById(String id);

    MsgPack getOrganizationAll();

    MsgPack getUserAll();

    MsgPack getOrgList(int pageIndex, int pageSize);

    MsgPack getUserList(int pageIndex, int pageSize);

    MsgPack getRoleList(int pageIndex, int pageSize);

    MsgPack getOrgInsertByObj(TSysOrganization organization);

    MsgPack getOrgInsertByObj(TSysUser user);

    MsgPack getOrgInsertByObj(TSysRole role);

    MsgPack getOrgDelById(String id);

    MsgPack getUserDelById(String id);

    MsgPack getRoleDelById(String id);

    MsgPack getUpdateOrgById(String id, TSysOrganization organization);

    MsgPack getUserUpdateById(String id, TSysUser user);

    MsgPack getRoleUpdateById(String id, TSysRole role);

    MsgPack getOrgInfoById(String id);

    MsgPack getUserInfoById(String id);

    MsgPack getRoleInfoById(String id);

}
