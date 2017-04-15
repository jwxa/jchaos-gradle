package com.github.jwxa.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/4/16 ProjectName: jchaos-gradle Version: 1.0
 */
@Configuration
public class ActiveMqConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
}
