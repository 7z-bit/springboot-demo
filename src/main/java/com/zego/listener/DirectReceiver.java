package com.zego.listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zego.entity.MultieloadParames;
import com.zego.util.JsonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

@Component
public class DirectReceiver {

    @RabbitListener(queues = "zegobird_recharge_queue")
    public void process(Message message) throws Exception{
        String messageStr = new String(message.getBody());
        MultieloadParames params = JsonUtil.toGenericObject(messageStr, new TypeReference<MultieloadParames>() {
        });
        String result="";
        String _token=params.getToken();
        String _mobile=params.getMobile();
        String _amount=params.getAmount();
        String _opt=params.getOpt();
        String _agentid=params.getAgentId();
        String _fmt=params.getFmt();
        System.out.println("DirectReceiver消费者收到消息  : " + _mobile);
    }
}
