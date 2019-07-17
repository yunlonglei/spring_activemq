package com.lei.activemq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: leiyunlong
 * @Date: 2019/7/17 14:40
 * @Version 1.0
 */
@Service
public class SpringMqConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMqConsumer consumer = (SpringMqConsumer) act.getBean("springMqConsumer");
        //这里也可以强制转换成String类型来接收
        Object receiveValue = consumer.jmsTemplate.receiveAndConvert();
        System.out.println("消费者接受到的消息是：" + receiveValue);
    }
}
