package com.codeshop.spring.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义一个配置类，可以在application.yml中配置，使用com.codeshop.author|name、email格式
 * 然后其他地方可以直接获取MyConfig的Bean
 */
@Component
@ConfigurationProperties(prefix = "com.codeshop.author")
@Data
public class MyConfig {
    private String name;
    private String email;
}
