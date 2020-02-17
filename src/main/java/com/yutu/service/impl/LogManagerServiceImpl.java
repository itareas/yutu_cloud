package com.yutu.service.impl;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TLogOperation;
import com.yutu.mapper.mysql.TLogLandingMapper;
import com.yutu.mapper.mysql.TLogOperationMapper;
import com.yutu.service.ILogManagerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: LogServiceImpl
 * @Author: zhaobc
 * @Date: 2019/4/21 17:30
 * @Description: 日志操作类
 **/
@Service
public class LogManagerServiceImpl implements ILogManagerService {
    @Resource
    private TLogLandingMapper logLandingMapper;
    @Resource
    private TLogOperationMapper logOperationMapper;

    Logger logger = Logger.getLogger(LogManagerServiceImpl.class);
    /**
     * @Author: zhaobc
     * @Date: 2019/5/20 11:20
     * @Description: 插入登陆日志功能
     **/
    @Override
    public MsgPack insertLandingLog(TLogLanding landing) {
        MsgPack msgPack =new MsgPack();
        int landingCount= logLandingMapper.insert(landing);
        if(landingCount>0){
            msgPack.setStatus(1);
        }else{
            msgPack.setStatus(0);
        }
        logger.info("=============================>"+landing.getLoginAppname()+"日志插入" + landingCount + "条-------------------------------\r\n");
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 14:59
    * @Description: 插入系统操作日志
    **/
    @Override
    public MsgPack insertOperationLog(TLogOperation operation) {
        MsgPack msgPack =new MsgPack();
        int operationCount= logOperationMapper.insert(operation);
        if(operationCount>0){
            msgPack.setStatus(1);
        }else{
            msgPack.setStatus(0);
        }
        logger.info("=============================>"+"数据操作日志插入" + operationCount + "条-------------------------------\r\n");
        return msgPack;
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
}
