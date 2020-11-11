package com.yutu.controller.frame;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.entity.table.TSysOrganization;
import com.yutu.service.frame.IPowerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhaobc
 * @Date: 2020/1/21 10:25
 * @Description:菜单模型前端接口
 */
@RestController
@RequestMapping(value = "menu")
public class MenuController {
    @Resource
    private IPowerService iPowerService;

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:37
     * @Description: 获得系统菜单列表  分页
     **/
    @RequestMapping(value = "sys/list")
    public MsgPack getMenuSysList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuSysList(1, 20);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:38
     * @Description: 获得业务菜单列表  分页
     **/
    @RequestMapping(value = "bug/list")
    public MsgPack getMenuBusList(HttpServletRequest request) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuBusList(1, 20);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:38
     * @Description: 根据id新增系统菜单
     **/
    @RequestMapping(value = "sys/insert")
    public MsgPack getMenuSysInsertById(@RequestBody TMenuSystem tMenuSystem) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuSysInsertById(tMenuSystem);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:39
     * @Description: 根据id新增业务菜单
     **/
    @RequestMapping(value = "bus/insert")
    public MsgPack getMenuBusInsertById(@RequestBody TMenuBusiness tMenuBusiness) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuBusInsertById(tMenuBusiness);
        return msgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2020/1/21 11:44
     * @Description:
     **/
    @RequestMapping(value = "sys/delete/{id}")
    public MsgPack getMenuSysDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuSysDelById(id);
        return msgPack;
    }

    @RequestMapping(value = "bus/delete/{id}")
    public MsgPack getMenuBusDelById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuBusDelById(id);
        return msgPack;
    }

    @RequestMapping(value = "sys/update/{id}")
    public MsgPack getMenuSysUpdateById(@PathVariable String id, @RequestBody TMenuSystem menuSystem) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuSysUpdateById(id, menuSystem);
        return msgPack;
    }

    @RequestMapping(value = "bus/update/{id}")
    public MsgPack getMenuBusUpdateById(@PathVariable String id, @RequestBody TMenuBusiness tMenuBusiness) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuBusUpdateById(id, tMenuBusiness);
        return msgPack;
    }

    @RequestMapping(value = "sys/info/{id}")
    public MsgPack getMenuSysInfoById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuSysInfoById(id);
        return msgPack;
    }

    @RequestMapping(value = "bus/info/{id}")
    public MsgPack getMenuBusInfoById(@PathVariable String id) {
        MsgPack msgPack = new MsgPack();
        msgPack = iPowerService.getMenuBusInfoById(id);
        return msgPack;
    }


}
