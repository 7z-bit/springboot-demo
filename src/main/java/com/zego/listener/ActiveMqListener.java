package com.zego.listener;

import com.zego.common.Globals;
import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.MapMessage;

@Service
public class ActiveMqListener {

    @JmsListener(destination = Globals.ACTIVE_QUEUE)
    public void rctiveMsg(Message message){
        try {
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                String target = mapMessage.getString("target");
                String contentJson = mapMessage.getObject("content").toString();
//                RechargeLog log = JsonUtil.toGenericObject(contentJson,
//                        new TypeReference<RechargeLog>() {
//                        });
                System.out.println(contentJson);
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
