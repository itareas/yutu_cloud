package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.mapper.mysql.TSysOrganizationMapper;
import com.yutu.service.IOrganizationService;
import com.yutu.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 19:05
 * @Description:
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Resource
    private TSysOrganizationMapper tSysOrganizationMapper;

    @Override
    public MsgPack insertOrganization(TSysOrganization organization) {
        MsgPack msgPack=new MsgPack();
        int orgInsertCount= tSysOrganizationMapper.insert(organization);
        if(orgInsertCount>0){
            msgPack.setStatus(1);
        }else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }

    @Override
    public MsgPack updateOrganization(TSysOrganization organization) {
        MsgPack msgPack=new MsgPack();
        int orgUpdateCount= tSysOrganizationMapper.updateByPrimaryKey(organization);
        if(orgUpdateCount>0){
            msgPack.setStatus(1);
        }else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }

    @Override
    public MsgPack delteOrganization(String orgId) {
        MsgPack msgPack=new MsgPack();
        int orgDelCount= tSysOrganizationMapper.deleteByPrimaryKey(orgId);
        if(orgDelCount>0){
            msgPack.setStatus(1);
        }else {
            msgPack.setStatus(0);
        }
        return msgPack;
    }
}
