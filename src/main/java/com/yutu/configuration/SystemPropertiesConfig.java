package com.yutu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019/6/21 9:55
 * @Description: 系统核心配置文件
 **/
@Configuration
public class SystemPropertiesConfig {
    /**
     * @Author: zhaobc
     * @Date: 2019-12-18 17:33
     * @Description:系统登陆存储方式
     **/
    public static String System_LoginStorage_Type;
    /**
     * @Author: zhaobc
     * @Date: 2019-12-18 17:33
     * @Description:系统用户类型
     **/
    public static String System_Login_Type;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-18 17:33
     * @Description:系统授权令牌名称
     **/
    public static String System_Auth_Token;
    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 是否启用拦截器
     **/
    public static String System_Interceptor_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 拦截器超时时间
     **/
    public static String System_Interceptor_OverTime;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 15:40
     * @Description: 是否启动黑名单机制
     **/
    public static String System_Blacklist_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 15:40
     * @Description: 一分钟最多访问次数
     **/
    public static String System_Blacklist_MaxNumber;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/15 21:15
     * @Description: 是否启动Xss和Sql过滤
     **/
    public static String System_XssAndSql_StartUp;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 过滤器放行的路径
     **/
    public static String System_Filter_Path;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 系统首页
     **/
    public static String System_Home_Page;

    /**
     * @Author: zhaobc
     * @Date: 2019/4/17 16:15
     * @Description: 系统登陆页
     **/
    public static String System_Login_Page;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/1 11:51
     * @Description: 系统内部所有注册的请求地址
     **/
    public static List<String> System_Register_Request;


    /**
     * @Author: zhaobc
     * @Date: 2019-12-17 16:03
     * @Description: token过期时间
     **/
    public static String System_Token_TimeOut;

    @Value("${System.LoginStorage.Type}")
    public void setSystem_LoginStorage_Type(String system_LoginStorage_Type) {
        System_LoginStorage_Type = system_LoginStorage_Type;
    }

    @Value("${System.Login.Type}")
    public void setSystem_Login_Type(String system_Login_Type) {
        System_Login_Type = system_Login_Type;
    }

    @Value("${System.Auth.Token}")
    public void setSystem_Auth_Token(String system_Auth_Token) {
        System_Auth_Token = system_Auth_Token;
    }

    @Value("${System.Interceptor.StartUp}")
    public void setSystem_Interceptor_StartUp(String system_Interceptor_StartUp) {
        System_Interceptor_StartUp = system_Interceptor_StartUp;
    }

    @Value("${System.Interceptor.OverTime}")
    public void setSystem_Interceptor_OverTime(String system_Interceptor_OverTime) {
        System_Interceptor_OverTime = system_Interceptor_OverTime;
    }

    @Value("${System.Blacklist.StartUp}")
    public void setSystem_Blacklist_StartUp(String system_Blacklist_StartUp) {
        System_Blacklist_StartUp = system_Blacklist_StartUp;
    }

    @Value("${System.Blacklist.MaxNumber}")
    public void setSystem_Blacklist_MaxNumber(String system_Blacklist_MaxNumber) {
        System_Blacklist_MaxNumber = system_Blacklist_MaxNumber;
    }

    @Value("${System.XssAndSql.StartUp}")
    public void setSystem_XssAndSql_StartUp(String system_XssAndSql_StartUp) {
        System_XssAndSql_StartUp = system_XssAndSql_StartUp;
    }

    @Value("${System.Filter.Path}")
    public void setSystem_Filter_Path(String system_Filter_Path) {
        System_Filter_Path = system_Filter_Path;
    }

    @Value("${System.Home.Page}")
    public void setSystem_Home_Page(String system_Home_Page) {
        System_Home_Page = system_Home_Page;
    }

    @Value("${System.Login.Page}")
    public void setSystem_Login_Page(String system_Login_Page) {
        System_Login_Page = system_Login_Page;
    }

    @Value("${System.Token.TimeOut}")
    public void setSystem_Token_TimeOut(String system_Token_TimeOut) {
        System_Token_TimeOut = system_Token_TimeOut;
    }
}
