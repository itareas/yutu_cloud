package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TLogOperation;
import com.yutu.service.ILogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:日志接口服务
 */
@RestController
@RequestMapping("/log")
public class LogService {
    @Resource
    private ILogService logService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:46
     * @Description: 子系统登陆/注销日志
     **/
    @RequestMapping(value = "/log/landing")
    @ResponseBody
    public MsgPack landing(TLogLanding landing) {
        MsgPack msgPack =new MsgPack();
        //插入日志
        msgPack=logService.insertLandingLog(landing);
       return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 14:56
    * @Description: 系统操作日志
    **/
    @RequestMapping(value = "/log/operation")
    @ResponseBody
    public MsgPack operation(TLogOperation operation) {
        MsgPack msgPack =new MsgPack();
        //插入日志
        msgPack=logService.insertOperationLog(operation);

        return msgPack;
    }
}
