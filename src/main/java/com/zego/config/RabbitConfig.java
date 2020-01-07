package com.zego.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    //队列
    @Bean
    public Queue rechargeQueue(){
        return new Queue("zegobird_recharge_queue", true);
    }

    //Direct交换机
    @Bean
    DirectExchange rechargeExchange(){
        return new DirectExchange("zegobird");
    }

    //绑定  将队列和交换机绑定  并设置用于匹配健
    @Bean
    Binding bingingDirect(){
        return BindingBuilder.bind(rechargeQueue()).to(rechargeExchange()).with("zegobirdRechargeQueueKey");
    }
}
