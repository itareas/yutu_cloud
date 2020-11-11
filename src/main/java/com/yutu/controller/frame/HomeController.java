package com.yutu.controller.frame;

import com.alibaba.fastjson.JSON;
import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.service.frame.IHomeService;
import com.yutu.utils.frame.SessionUserManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HomeController
 * @Author: zhaobc
 * @Date: 2019/6/26 17:34
 * @Description:框架主页数据测试
 **/
@RestController
@RequestMapping(value = "home")
public class HomeController {
    @Resource
    private IHomeService homeService;
    @Resource
    private SessionUserManager sessionUserManager;

    /**
    * @Author: zhaobc
    * @Date: 2019/12/15 18:07
    * @Description: 获得系统菜单列表
    **/
    @RequestMapping(value = "menu/sys/list")
    public MsgPack getSysMenuList(HttpServletRequest request) {
        MsgPack<List<TMenuSystem>> msgPask = new MsgPack<List<TMenuSystem>>();
        SessionUser sessionUser =(SessionUser) sessionUserManager.getSessionUser();
        if(sessionUser!=null){
            msgPask.setStatus(1);
            String strMenu=sessionUser.getMenuSys();
            List<TMenuSystem> menu= JSON.parseArray(strMenu,TMenuSystem.class);
            List<TMenuSystem> menuReturn=new ArrayList<>();
            //便利菜单添加token
            for ( TMenuSystem tMenuSystem  : menu){
                String menuUrl=tMenuSystem.getMenuUrl();
                tMenuSystem.setMenuUrl(menuUrl+"?token="+sessionUser.getToken());
                menuReturn.add(tMenuSystem);
            }
            msgPask.setData(menuReturn);
        }else {
            msgPask.setStatus(0);
        }
        return msgPask;
    }
}
