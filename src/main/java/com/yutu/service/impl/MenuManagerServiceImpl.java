package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.mapper.mysql.TMenuBusinessMapper;
import com.yutu.mapper.mysql.TMenuSystemMapper;
import com.yutu.service.IMenuManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019-12-23 14:21
 * @Description:菜单管理实现类
 */
@Service
public class MenuManagerServiceImpl implements IMenuManagerService {
    @Resource
    private TMenuBusinessMapper tMenuBusinessMapper;

    @Override
    public MsgPack getBusinessMenuList(String roleId) {
        MsgPack msgPack=new MsgPack();
        List<TMenuBusiness> listMenu=tMenuBusinessMapper.getRoleMenuBus(roleId);
        if(listMenu.size()>0){
            msgPack.setStatus(1);
            msgPack.setData(listMenu);
        }
        return msgPack;
    }

    @Override
    public MsgPack getMenuSysList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getMenuBusList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getMenuSysInsertById(TMenuSystem menuSystem) {
        return null;
    }

    @Override
    public MsgPack getMenuBusInsertById(TMenuBusiness menuBusiness) {
        return null;
    }

    @Override
    public MsgPack getMenuSysDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getMenuBusDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getMenuSysUpdateById(String id, TMenuSystem menuSystem) {
        return null;
    }

    @Override
    public MsgPack getMenuBusUpdateById(String id, TMenuBusiness menuBusiness) {
        return null;
    }

    @Override
    public MsgPack getMenuSysInfoById(String id) {
        return null;
    }

    @Override
    public MsgPack getMenuBusInfoById(String id) {
        return null;
    }
}
