package com.codeshop.feignapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class SpringCloudFeignInheritApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignInheritApiApplication.class, args);
    }

}
