package com.yutu.webapi;

import com.alibaba.fastjson.JSON;
import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysUser;
import com.yutu.service.ILogManagerService;
import com.yutu.utils.AESUtils;
import com.yutu.utils.RedisUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WebController
 * @Author: zhaobc
 * @Date: 2019/4/23
 * @Description: web网站对外接口  接口类型：rest
 **/
@Component
@Path("Service")
public class WebService {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private ILogManagerService logManageService;

    @GET
    @Path(value = "getTest")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTest(@BeanParam TSysUser user) {
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
}
