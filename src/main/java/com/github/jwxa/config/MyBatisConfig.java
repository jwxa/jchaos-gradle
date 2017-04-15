package com.github.jwxa.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@Configuration
@MapperScan("com.github.jwxa.mapper")
public class MyBatisConfig {
}
