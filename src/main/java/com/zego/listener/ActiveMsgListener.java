package com.zego.listener;

import org.springframework.stereotype.Service;

@Service
public class ActiveMsgListener {

//    @JmsListener(destination = "log.queue")
//    public void rctiveMsg(Message message){
//        try {
//            if (message instanceof MapMessage) {
//                MapMessage mapMessage = (MapMessage) message;
//                String target = mapMessage.getString("target");
//                String contentJson = mapMessage.getObject("content").toString();
//                RechargeLog log = JsonUtil.toGenericObject(contentJson,
//                        new TypeReference<RechargeLog>() {
//                        });
//                System.out.println(log.toString());
//                //保存日志信息
////                rechargeLogService.save(log);
//            }
//        } catch (Exception e) {
//            System.out.println("Deal with ActiveMQ message fail, error message: " + e.getMessage());
//        }
//    }
}
