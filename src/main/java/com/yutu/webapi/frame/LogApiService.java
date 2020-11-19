package com.yutu.webapi.frame;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TLogOperation;
import com.yutu.service.frame.ILoginService;
import com.yutu.service.frame.IPowerService;
import com.yutu.utils.frame.TokenManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Author: zhaobc
 * @Date: 2019-12-19 13:53
 * @Description:日志接口服务
 */
@Component
@Path("log")
public class LogApiService {
    @Resource
    private IPowerService iPowerService;

    @Resource
    private ILoginService loginService;

    @Resource
    HttpServletRequest request;

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
        if (TokenManager.verificationToken(landing.getToken(), TokenManager.getSecurity(request))) {
            switch (type) {
                case "add":
                    //插入日志
                    if (landing.getUuid().length() > 0) {
                        msgPack = iPowerService.insertLandingLog(landing);
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
        if (TokenManager.verificationToken(operation.getToken(), TokenManager.getSecurity(request))) {
            switch (type) {
                case "add":
                    if (operation.getUuid().length() > 0) {
                        //插入日志
                        msgPack = iPowerService.insertOperationLog(operation);
                    }
                    break;
            }
        }
        return msgPack;
    }
}
