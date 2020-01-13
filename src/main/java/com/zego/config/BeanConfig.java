package com.zego.config;

import com.zego.common.Globals;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class BeanConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(Globals.ACTIVE_QUEUE);
    }
}
