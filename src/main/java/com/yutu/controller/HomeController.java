package com.yutu.controller;

import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.service.IHomeService;
import com.yutu.util.JsonListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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


    /**
    * @Author: zhaobc
    * @Date: 2019/12/15 18:07
    * @Description: 获得系统菜单列表
    **/
    @RequestMapping(value = "getSysMenuList")
    public MsgPack getSysMenuList(HttpSession session) {
        MsgPack<List<TMenuSystem>> msgPask = new MsgPack<List<TMenuSystem>>();
        SessionUser user =(SessionUser) session.getAttribute(session.getId());
        if(user!=null){
            msgPask.setStatus(1);
            String strMenu=user.getMenu();
            List<TMenuSystem> menu= JsonListUtil.jsonToList(strMenu,TMenuSystem.class);
            msgPask.setData(menu);
        }else {
            msgPask.setStatus(1);
        }
        return msgPask;
    }
}
