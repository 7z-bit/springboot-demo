package com.zego.service.impl;

import com.zego.common.Globals;
import com.zego.entity.RechargeLog;
import com.zego.util.JsonUtil;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class SendActiveMqMessage {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessageMQ(RechargeLog log){
        jmsTemplate.send(Globals.ACTIVE_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                /** 创建Map集合的消息 */
                MapMessage mapMessage = new ActiveMQMapMessage();
                mapMessage.setString("target", "logContent");
                mapMessage.setObject("content", JsonUtil.toJson(log));
                return mapMessage;
            }
        });
    }
}
