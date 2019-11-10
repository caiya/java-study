package com.codeshop.dubbo.consumer;

import com.codeshop.dubbo.consumer.config.ConsumerConfiguration;
import com.codeshop.dubbo.consumer.service.ConsumerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();

        ConsumerService consumerService = context.getBean(ConsumerService.class);
        String result = consumerService.doSayHello("hello world!");
        System.out.println(result);
        System.in.read();
    }
}
