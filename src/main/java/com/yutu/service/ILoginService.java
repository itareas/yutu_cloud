package com.yutu.service;

import com.yutu.entity.MsgPack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:ILoginService
 * @Author:zhaobc
 * @Date:2019/4/16 11:55
 * @Description:登录服务接口层
 **/
public interface ILoginService {
    /**
     * @Author:zhaobc
     * @Date:2019/4/16 15:20
     * @Description:查询用户名信息
     **/
    MsgPack getLoginVerification(HttpServletRequest request, String userAccount, String userPwd);

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 15:41
    * @Description: 对外密码登录
    **/
    MsgPack getAuthPwdLogin(String userAccount,String userPwd);

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 15:46
    * @Description: 对外单点登录
    **/
    MsgPack getAuthSSOLogin(String appkey,String token);
}
