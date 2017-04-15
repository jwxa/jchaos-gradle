package com.github.jwxa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/27 ProjectName: jchaos-gradle Version: 1.0
 */
@SpringBootApplication
@EnableScheduling//启用定时任务的配置
@EnableAsync//实现异步调用
@MapperScan("com.github.jwxa.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
