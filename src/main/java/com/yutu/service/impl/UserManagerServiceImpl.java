package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysUser;
import com.yutu.mapper.mysql.TSysUserMapper;
import com.yutu.service.IUserManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public MsgPack insertUser(TSysUser user) {
        MsgPack msgPack=new MsgPack();
        int userInsertCount= tSysUserMapper.insert(user);
        if(userInsertCount>0){
            msgPack.setStatus(1);
        }
        return msgPack;
    }

    @Override
    public MsgPack updateUser(TSysUser user) {
        MsgPack msgPack=new MsgPack();
        int userUpdateCount= tSysUserMapper.updateByPrimaryKey(user);
        if(userUpdateCount>0){
            msgPack.setStatus(1);
        }
        return msgPack;
    }

    @Override
    public MsgPack delteUser(String userId) {
        MsgPack msgPack=new MsgPack();
        int userDelCount= tSysUserMapper.deleteByPrimaryKey(userId);
        if(userDelCount>0){
            msgPack.setStatus(1);
        }
        return msgPack;
    }
}
