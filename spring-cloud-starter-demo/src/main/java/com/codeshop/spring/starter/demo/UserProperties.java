package com.codeshop.spring.starter.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.user")
public class UserProperties {
    private String name;
}
