package com.mq.consumera.listener;

import com.mq.common.dto.MQObj;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {
    @JmsListener(destination = "publish.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public MQObj receive(MQObj obj){
        System.out.println("QueueListener: consumer-a 收到一条信息: " + obj.toString());
        String msg = "consumer-a received : ";
        obj.setMsg(msg);
        return obj;
    }



}
