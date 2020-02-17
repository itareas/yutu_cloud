package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.entity.table.TSysRole;
import com.yutu.entity.table.TSysUser;
import com.yutu.mapper.mysql.TSysOrganizationMapper;
import com.yutu.mapper.mysql.TSysUserMapper;
import com.yutu.service.IAuthorityManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:33
 * @Description: 权限业务处理层
 */
public class AuthorityManagerServiceImpl implements IAuthorityManagerService {
    @Resource
    private TSysOrganizationMapper tSysOrganizationMapper;

    @Resource
    private TSysUserMapper tSysUserMapper;


    @Override
    public MsgPack getOrganizationAll() {
        MsgPack msgPack=new MsgPack();
        List<TSysOrganization> listOrgAll= tSysOrganizationMapper.getOrganizationAll();
        if(listOrgAll!=null&&listOrgAll.size()>0){
            msgPack.setStatus(1);
            msgPack.setData(listOrgAll);
        }
        return msgPack;
    }

    @Override
    public MsgPack getUserAll() {
        MsgPack msgPack=new MsgPack();
        List<TSysUser> listUserAll= tSysUserMapper.getUserAll();
        if(listUserAll!=null&&listUserAll.size()>0){
            msgPack.setStatus(1);
            msgPack.setData(listUserAll);
        }
        return msgPack;
    }

    @Override
    public MsgPack getOrgList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getUserList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getRoleList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getOrgInsertByObj(TSysOrganization organization) {
        return null;
    }

    @Override
    public MsgPack getOrgInsertByObj(TSysUser user) {
        return null;
    }

    @Override
    public MsgPack getOrgInsertByObj(TSysRole role) {
        return null;
    }

    @Override
    public MsgPack getOrgDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getUserDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getRoleDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getUpdateOrgById(String id, TSysOrganization organization) {
        return null;
    }

    @Override
    public MsgPack getUserUpdateById(String id, TSysUser user) {
        return null;
    }

    @Override
    public MsgPack getRoleUpdateById(String id, TSysRole role) {
        return null;
    }

    @Override
    public MsgPack getOrgInfoById(String id) {
        return null;
    }

    @Override
    public MsgPack getUserInfoById(String id) {
        return null;
    }

    @Override
    public MsgPack getRoleInfoById(String id) {
        return null;
    }
}
