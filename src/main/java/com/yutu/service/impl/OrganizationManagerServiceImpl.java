package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.mapper.mysql.TSysOrganizationMapper;
import com.yutu.service.IOrganizationManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 19:05
 * @Description:
 */
@Service
public class OrganizationManagerServiceImpl implements IOrganizationManagerService {
    @Resource
    private TSysOrganizationMapper tSysOrganizationMapper;


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
}
