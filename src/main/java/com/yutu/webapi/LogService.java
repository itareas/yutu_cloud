package com.yutu.webapi;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TLogOperation;
import com.yutu.service.ILogManagerService;
import com.yutu.service.ILoginService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:日志接口服务
 */
@Component
@Path("log")
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
    @POST
    @Path(value = "landing/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack landing(@PathParam("type") String type, TLogLanding landing) {
        MsgPack msgPack = new MsgPack();
        //验证appKey 和 token
        msgPack = loginService.getAuthSSOLogin(landing.getAppkey(), landing.getToken());
        if (msgPack.getStatus() == 1) {
            switch (type) {
                case "add":
                    //插入日志
                    if (landing.getUuid().length() > 0) {
                        msgPack = logManageService.insertLandingLog(landing);
                    }
                    break;
            }
        }
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 14:56
     * @Description: 系统操作日志
     **/
    @POST
    @Path(value = "operation/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public MsgPack operation(@PathParam("type") String type, TLogOperation operation) {
        MsgPack msgPack = new MsgPack();
        msgPack = loginService.getAuthSSOLogin(operation.getAppkey(), operation.getToken());
        if (msgPack.getStatus() == 1) {
            switch (type) {
                case "add":
                    if (operation.getUuid().length() > 0) {
                        //插入日志
                        msgPack = logManageService.insertOperationLog(operation);
                    }
                    break;
            }
        }
        return msgPack;
    }
}
