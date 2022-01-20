package com.mq.consumera.listener;

import com.mq.common.dto.MQObj;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(MQObj obj){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + obj);
    }
}
