package com.yutu.webapi;

import com.alibaba.fastjson.JSON;
import com.yutu.entity.MsgPack;
import com.yutu.entity.SessionUser;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TSysUser;
import com.yutu.service.ILogManagerService;
import com.yutu.util.AESUtils;
import com.yutu.util.RedisUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: WebController
 * @Author: zhaobc
 * @Date: 2019/4/23
 * @Description: web网站对外接口  接口类型：rest
 **/
@RestController
@RequestMapping("/api/web")
public class WebService {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private ILogManagerService logManageService;

    @PostMapping("/getTest")
    @ResponseBody
    public String getTest(TSysUser user) {
        MsgPack<Map> msgPack = new MsgPack();
        if (user.getUserAccount() != null && user.getUserPwd() != null) {
            msgPack.setStatus(1);
            msgPack.setMsg("成功！");
        } else {
            msgPack.setStatus(0);
            msgPack.setMsg("key或者value为null");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("OurFavorite", "Hello World");
        map.put(user.getUserAccount(), user.getUserPwd());
        msgPack.setData(map);
        //创建加密泛型类
        AESUtils<MsgPack> aes = new AESUtils<MsgPack>();
        //进行AES加密
        String aesMsgPack = aes.encrypt(msgPack);
        //进行AES解密  Map.class为data数据的类型
        MsgPack decryptMsgPack = aes.decrypt(aesMsgPack, Map.class);
        System.out.print("=========>" + JSON.toJSON(decryptMsgPack) + "--------------");
        return aesMsgPack;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 9:46
     * @Description: 子系统登陆/注销日志
     **/
    @RequestMapping(value = "/manageLog")
    public void manageLog(HttpServletRequest request, String token,String logType,String appName) {
        //获得参数插入日志
        TLogLanding landing = new TLogLanding();
        if (token != null) {
            SessionUser sessionUser = (SessionUser) redisUtils.get(token);
            landing.setUuid(UUID.randomUUID().toString());
            landing.setLoginUserid(sessionUser.getUuid());
            landing.setLoginAccount(sessionUser.getUserAccount());
            landing.setLoginAddress(request.getServletPath());
            landing.setLoginSessionid(token);
            landing.setLoginDate(new Date());
            landing.setLoginType(logType);
            landing.setLoginAppname(appName);
            landing.setLoginIp(request.getRemoteAddr());
        }
        landing.setLoginResult(1);
        //插入日志
        logManageService.insertLandingLog(landing);
    }
}
