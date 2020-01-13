package com.zego.listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zego.common.Globals;
import com.zego.entity.MultieloadParames;
import com.zego.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = Globals.RABBIT_QUEUE)
    @RabbitHandler
    public void process(Message message, Channel channel) throws Exception{
        String messageStr = new String(message.getBody());
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        MultieloadParames params = JsonUtil.toGenericObject(messageStr, new TypeReference<MultieloadParames>() {});
        System.out.println("消费者收到消息  : " + messageStr);
    }
}
