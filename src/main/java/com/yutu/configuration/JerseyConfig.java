package com.yutu.configuration;

import com.yutu.webapi.AuthService;
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
        // 注册JSON转换器
        register(JacksonJsonProvider.class);
        //注册文件上传模块
        register(AuthService.class);
    }
}
