package com.lei.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @Author: leiyunlong
 * @Date: 2019/7/17 10:44
 * @Version 1.0
 */
@Service
public class SpringMqProduce {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMqProduce produce = (SpringMqProduce) act.getBean("springMqProduce");
//        springmqProduce produce1 = new springmqProduce();

        produce.jmsTemplate.send((session) -> {
            TextMessage textMessage = session.createTextMessage("*****spring和activemq整合消息*****");
            return textMessage;
        });
        System.out.println("spring和activemq整合消息发布完成！");
    }
}
