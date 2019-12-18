package com.yutu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//程序住入口
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//定时任务
@EnableScheduling
//扫描拦截器的WebFilter的
@ServletComponentScan
public class YutuApplication {

    public static void main(String[] args) {
        SpringApplication.run(YutuApplication.class, args);
    }

}
