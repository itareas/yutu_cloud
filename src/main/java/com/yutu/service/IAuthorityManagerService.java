package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.entity.table.TSysRole;
import com.yutu.entity.table.TSysUser;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:31
 * @Description:权限业务操作层
 */
public interface IAuthorityManagerService {
    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 新增部门
     **/
    MsgPack getOrganizationAll();

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 获得所有用户
     **/
    MsgPack getUserAll();


    MsgPack getOrgList(int pageIndex,int pageSize);

    MsgPack getUserList(int pageIndex,int pageSize);

    MsgPack getRoleList(int pageIndex,int pageSize);

    MsgPack getOrgInsertByObj(TSysOrganization organization);

    MsgPack getOrgInsertByObj(TSysUser user);

    MsgPack getOrgInsertByObj(TSysRole role);

    MsgPack getOrgDelById(String id);

    MsgPack getUserDelById(String id);

    MsgPack getRoleDelById(String id);

    MsgPack getUpdateOrgById(String id ,TSysOrganization organization);

    MsgPack getUserUpdateById(String id ,TSysUser user);

    MsgPack getRoleUpdateById(String id ,TSysRole role);

    MsgPack getOrgInfoById(String id);

    MsgPack getUserInfoById(String id);

    MsgPack getRoleInfoById(String id);

}
