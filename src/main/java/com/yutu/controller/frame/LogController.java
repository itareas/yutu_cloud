package com.yutu.controller.frame;

import com.yutu.entity.MsgPack;
import com.yutu.service.frame.IPowerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:26
 * @Description:日志前端接口层
 */
@RestController
@RequestMapping(value = "log")
public class LogController {
    @Resource
    private IPowerService iPowerService;

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:31
    * @Description: 获得登录日志列表  分页
    **/
    @RequestMapping(value = "landing/list")
    public MsgPack getLogLandingList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogLandingList(1,20);
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:31
    * @Description: 获得操作日志列表
    **/
    @RequestMapping(value = "operation/list")
    public MsgPack getLogOperationList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogOperationList(1,20);
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:31
    * @Description:获得错误日志列表
    **/
    @RequestMapping(value = "error/list")
    public MsgPack getLogErrorList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogErrorList(1,20);
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:32
    * @Description: 删除登录日志
    **/
    @RequestMapping(value = "landing/delete/{id}")
    public MsgPack getLogLandingDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogLandingDelById(id);
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:32
    * @Description: 删除操作日志
    **/
    @RequestMapping(value = "operation/delete/{id}")
    public MsgPack getLogOperationDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogOperationDelById(id);
        return msgPack;
    }

    /**
    * @Author: zhaobc
    * @Date: 2020/1/21 11:32
    * @Description: 删除错误日志
    **/
    @RequestMapping(value = "error/delete/{id}")
    public MsgPack getLogErrorDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack= iPowerService.getLogErrorDelById(id);
        return msgPack;
    }
}
