package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.entity.table.TSysUser;
import com.yutu.mapper.mysql.TSysUserMapper;
import com.yutu.service.IUserManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 19:05
 * @Description:
 */
@Service
public class UserManagerServiceImpl implements IUserManagerService {
    @Resource
    private TSysUserMapper tSysUserMapper;


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
}
