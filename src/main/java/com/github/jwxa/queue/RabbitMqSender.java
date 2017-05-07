package com.github.jwxa.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/5/7 ProjectName: jchaos-gradle Version: 1.0
 */
@Component
public class RabbitMqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Scheduled(fixedDelay=3000)//每3s执行1次
    public void send() {
        String context = "hello rabbitMq ," + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

}
