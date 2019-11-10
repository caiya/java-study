package com.codeshop.dubbo.consumer;

import com.codeshop.dubbo.provider.service.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ProviderService providerService = (ProviderService) context.getBean("providerService");
        String result = providerService.SayHello("hello world!");
        System.out.println(result);
        System.in.read();
    }
}
