package com.codeshop.dubbo.provider;

import com.codeshop.dubbo.provider.config.DubboConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        context.start();
        System.in.read();
    }
}
