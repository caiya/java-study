package com.codeshop.spring.cloud;

import com.codeshop.spring.cloud.util.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudStarterApplication {

    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(SpringCloudStarterApplication.class, args);
    }

}
