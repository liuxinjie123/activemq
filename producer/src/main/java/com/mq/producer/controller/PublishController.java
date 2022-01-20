package com.mq.producer.controller;

import com.mq.common.dto.MQObj;
import com.mq.common.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/publish")
public class PublishController {
    @Resource
    private JmsMessagingTemplate jms;
    @Resource
    private Queue queue;
    @Resource
    private Topic topic;

    @GetMapping("/queue")
    public Response queue(){
        MQObj obj;
        for (int i = 0; i < 10 ; i++) {
            obj = new MQObj();
            obj.setData("queue"+i);
            jms.convertAndSend(queue, obj);
        }

        return Response.success();
    }

    @GetMapping(value = "/queue/obj")
    public Response sendObjQueueMsg(String msg) {
        MQObj obj = new MQObj();
        obj.setData(msg);
        jms.convertAndSend(queue, obj);

        return Response.success();
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(MQObj obj){
        System.out.println(obj);
    }

    @RequestMapping("/topic")
    public String topic(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend(topic, "topic"+i);
        }

        return "topic 发送成功";
    }
}
