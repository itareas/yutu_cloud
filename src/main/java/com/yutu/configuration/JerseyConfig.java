package com.yutu.configuration;

import com.yutu.webapi.frame.AuthApiService;
import com.yutu.webapi.frame.LogApiService;
import com.yutu.webapi.frame.MenuApiService;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * @Author: zhaobc
 * @Date: 2019/12/26 23:05
 * @Description:
 */
@Component
@ApplicationPath("webapi")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //服务类所在的包路径
        packages("com.waylau.rest.resources");
        // 注册JSON转换器
        register(JacksonJsonProvider.class);
        //注册文接口模块
        register(AuthApiService.class);
        register(LogApiService.class);
        register(MenuApiService.class);
    }
}
