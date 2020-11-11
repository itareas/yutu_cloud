package com.yutu.configuration;

import com.yutu.entity.ConfigConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: zhaobc
 * @Date: 2020-02-19 9:56
 * @Description: 转换物理路径为网络路径
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:" + ConfigConstants.Attachment_Path + "/");
    }
}
