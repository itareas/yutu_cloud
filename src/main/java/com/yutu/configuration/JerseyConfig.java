package com.yutu.configuration;

import com.yutu.filter.MyFilter;
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
        register(MyFilter.class);
    }
}
