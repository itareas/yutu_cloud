package com.yutu.service.impl;

import com.yutu.configuration.SystemPropertiesConfig;
import com.yutu.entity.ConfigConstants;
import com.yutu.entity.MsgPack;
import com.yutu.entity.TokenInfo;
import com.yutu.entity.table.TCodConfig;
import com.yutu.entity.table.TLogLanding;
import com.yutu.entity.table.TMenuBusiness;
import com.yutu.entity.table.TMenuSystem;
import com.yutu.mapper.mysql.*;
import com.yutu.service.ILoginService;
import com.yutu.utils.SessionUserManager;
import com.yutu.utils.TokenManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @ClassName:LoginServiceImpl
 * @Author:zhaobc
 * @Date:2019/4/16 11:56
 * @Description:登录服务实现层
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    @Resource
    private TSysUserMapper sysUserMapper;
    @Resource
    private TLogLandingMapper logLandingMapper;
    @Resource
    private TMenuSystemMapper tMenuSystemMapper;
    @Resource
    private TMenuBusinessMapper tMenuBusinessMapper;
    @Resource
    private TCodConfigMapper tCodConfigMapper;
    @Resource
    private SessionUserManager sessionUserManager;
    @Resource
    private HttpServletRequest request;


    @Override
    public MsgPack getLoginVerification(String userAccount, String userPwd) {
        MsgPack msgPack = new MsgPack();
        //给密码md5加密
        userPwd = DigestUtils.md5Hex(userPwd + "cloud&Zhaobc@2019");
        Map<String,String> userInfo = sysUserMapper.getLoginVerification(userAccount, userPwd);

        //获得客户端身份信息便于验证
        String address = request.getServletPath();
        String ip = request.getRemoteAddr();
        // sesson中存储客户端标识字段，需要进行验证是否是登陆着
        String security = ip + "<yutu_frame>" + request.getHeader("User-Agent");

        //日志实体类 并赋值
        TLogLanding landing = new TLogLanding();
        landing.setUuid(UUID.randomUUID().toString());
        landing.setLoginAddress(address);
        landing.setLoginAccount(userAccount);
        landing.setLoginDate(new Date());
        landing.setLoginIp(ip);
        landing.setLoginType("门户登陆");
        landing.setLoginAppname("系统门户网站");
        HttpSession session = request.getSession();
        //判断登录是否成功
        if (userInfo != null) {
            //获得菜单列表
            List<TMenuSystem> listMenuSys=tMenuSystemMapper.getRoleMenuSys(userInfo.get("role_uuid"));
            List<TMenuBusiness>listMenuBus=new ArrayList<>();
            if(SystemPropertiesConfig.System_LoginStorage_Type.equals("redis")){
                listMenuBus=tMenuBusinessMapper.getRoleMenuBus(userInfo.get("role_uuid"));
            }
            //session存储用户信息操作
            msgPack= sessionUserManager.setSessionUser(session.getId(),security,userInfo,listMenuSys,listMenuBus);
            //记录日志
            landing.setLoginUserid(userInfo.get("uuid"));
            landing.setLoginSessionid(session.getId());
            landing.setLoginResult(msgPack.getStatus());
        }

        //数据库存储登录日志
        int landingCount = logLandingMapper.insert(landing);
        System.out.print("=============================>"+msgPack.getMsg()+"门户登陆日志插入" + landingCount + "条-------------------------------\r\n");

        return msgPack;
    }

    @Override
    public MsgPack getAuthPwdLogin(String userAccount, String userPwd) {
        MsgPack msgPack=new MsgPack();
        //验证用户密码
        Map<String,String> userInfo = sysUserMapper.getLoginVerification(userAccount, userPwd);
        if(userInfo!=null&&userInfo.size()>0){
            msgPack.setStatus(1);
            msgPack.setData(userInfo);
        }
        return msgPack;
    }

    @Override
    public MsgPack getAuthSSOLogin(String appKey,String token) {
       MsgPack msgPack=new MsgPack();
        //验证appkey
       String keyId= ConfigConstants.Auth_AppKey;
       List<TCodConfig> appList= tCodConfigMapper.getConfigListById(keyId,appKey);

       if(appList!=null && appList.size()<1){
           //appkey验证不通过
           return msgPack;
       }
        //验证token是否过期
        TokenInfo tokenInfo=TokenManager.getTokenInfoById(token);
         if(tokenInfo!=null){
             msgPack.setStatus(1);
             msgPack.setData(tokenInfo.getApiUser());
         }
         //返回用户信息
        return msgPack;
    }
}
