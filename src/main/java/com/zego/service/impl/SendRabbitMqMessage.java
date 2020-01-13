package com.zego.service.impl;

import javax.annotation.Resource;
import javax.jms.DeliveryMode;

import com.zego.entity.MultieloadParames;
import org.springframework.amqp.core.Message;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SendRabbitMqMessage {

    @Resource
    private AmqpTemplate amqpTemplate;

    private final static Logger logger = Logger.getLogger(SendRabbitMqMessage.class);

    //公共入队方法
    public void sendMessageToQueue(String queueKey, Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(object);
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType("application/json");
            messageProperties.setDeliveryTag(DeliveryMode.PERSISTENT);
            Message message = new Message(json.getBytes(),messageProperties);
            amqpTemplate.convertAndSend(queueKey, message);
        } catch (Exception e) {
            if(object instanceof MultieloadParames) {
                MultieloadParames multieloadParames = (MultieloadParames)object;
                logger.info("推送充值订单失败，"+ multieloadParames.toString() + e.toString());
            }
        }
    }

}