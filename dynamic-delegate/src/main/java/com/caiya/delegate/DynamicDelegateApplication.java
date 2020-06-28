package com.caiya.delegate;

import com.caiya.delegate.core.EnableProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProxy(basePackages = "com.caiya.delegate.service")
public class DynamicDelegateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDelegateApplication.class, args);
    }

}
