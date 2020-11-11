package com.yutu.service.frame.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.*;
import com.yutu.filter.MyFilter;
import com.yutu.mapper.frame.*;
import com.yutu.service.frame.IPowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:33
 * @Description: 权限业务处理层
 */
@Service
public class PowerServiceImpl implements IPowerService {
    @Resource
    private TSysOrganizationMapper tSysOrganizationMapper;
    @Resource
    private TMenuBusinessMapper tMenuBusinessMapper;
    @Resource
    private TLogLandingMapper logLandingMapper;
    @Resource
    private TLogOperationMapper logOperationMapper;
    @Resource
    private TSysUserMapper tSysUserMapper;

    private final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * @Author: zhaobc
     * @Date: 2019/5/20 11:20
     * @Description: 插入登陆日志功能
     **/
    @Override
    public MsgPack insertLandingLog(TLogLanding landing) {
        MsgPack msgPack = new MsgPack();
        int landingCount = logLandingMapper.insert(landing);
        if (landingCount > 0) {
            msgPack.setStatus(1);
        } else {
            msgPack.setStatus(0);
        }
        logger.info("=============================>" + landing.getLoginAppname() + "日志插入" + landingCount + "条-------------------------------\r\n");
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:59
     * @Description: 插入系统操作日志
     **/
    @Override
    public MsgPack insertOperationLog(TLogOperation operation) {
        MsgPack msgPack = new MsgPack();
        int operationCount = logOperationMapper.insert(operation);
        if (operationCount > 0) {
            msgPack.setStatus(1);
        } else {
            msgPack.setStatus(0);
        }
        logger.info("=============================>" + "数据操作日志插入" + operationCount + "条-------------------------------\r\n");
        return msgPack;
    }

    @Override
    public MsgPack getBusinessMenuList(String roleId) {
        MsgPack msgPack = new MsgPack();
        List<TMenuBusiness> listMenu = tMenuBusinessMapper.getRoleMenuBus(roleId);
        if (listMenu.size() > 0) {
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

    @Override
    public MsgPack getLogLandingList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getLogOperationList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getLogErrorList(int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public MsgPack getLogLandingDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getLogOperationDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getLogErrorDelById(String id) {
        return null;
    }

    @Override
    public MsgPack getOrganizationAll() {
        MsgPack msgPack = new MsgPack();
        List<TSysOrganization> listOrgAll = tSysOrganizationMapper.getOrganizationAll();
        if (listOrgAll != null && listOrgAll.size() > 0) {
            msgPack.setStatus(1);
            msgPack.setData(listOrgAll);
        }
        return msgPack;
    }

    @Override
    public MsgPack getUserAll() {
        MsgPack msgPack = new MsgPack();
        List<TSysUser> listUserAll = tSysUserMapper.getUserAll();
        if (listUserAll != null && listUserAll.size() > 0) {
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
