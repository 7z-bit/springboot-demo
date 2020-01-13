package com.zego.config;


import com.zego.common.Globals;
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
        return new Queue(Globals.RABBIT_QUEUE, true);
    }

    //Direct交换机
    @Bean
    DirectExchange rechargeExchange(){
        return new DirectExchange(Globals.RABBIT_EXCHANGE);
    }

    //绑定  将队列和交换机绑定  并设置用于匹配健
    @Bean
    Binding bingingDirect(){
        return BindingBuilder.bind(rechargeQueue()).to(rechargeExchange()).with(Globals.RABBIT_KEY);
    }
}
