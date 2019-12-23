package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.sync.SyncLogLanding;
import com.yutu.entity.sync.SyncLogOperation;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TLogOperation;
import com.yutu.service.ILogManagerService;
import com.yutu.service.ILoginService;
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
@RequestMapping("/api/log")
public class LogService {
    @Resource
    private ILogManagerService logManageService;

    @Resource
    private ILoginService loginService;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:46
     * @Description: 子系统登陆/注销日志
     **/
    @RequestMapping(value = "/log/landing")
    @ResponseBody
    public MsgPack landing(SyncLogLanding json) {
        MsgPack msgPack = new MsgPack();
        //验证appKey 和 token
        msgPack = loginService.getAuthSSOLogin(json.getAPPKEY(), json.getTOKEN());
        if(msgPack.getStatus()==1){
            TLogLanding landing=(TLogLanding) json;
            //插入日志
            msgPack = logManageService.insertLandingLog(landing);
        }

        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:56
     * @Description: 系统操作日志
     **/
    @RequestMapping(value = "/log/operation")
    @ResponseBody
    public MsgPack operation(SyncLogOperation json) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(json.getAPPKEY(), json.getTOKEN());
        if(msgPack.getStatus()==1) {
            TLogOperation landing = (TLogOperation) json;
            //插入日志
            msgPack = logManageService.insertOperationLog(landing);
        }
        return msgPack;
    }
}
