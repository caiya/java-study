package com.codeshop.spring.starter.demo;

import com.codeshop.spring.starter.demo.annotation.EnableUserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableUserClient
@SpringBootApplication
public class SpringCloudStarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStarterDemoApplication.class, args);
    }

}
