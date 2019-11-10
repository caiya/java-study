package com.codeshop.spring.starter.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfigure {

    /**
     * 添加一个enabled：是否启用标识，如果为true则自动配置UserClient，否则不会配置
     * @param userProperties
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "spring.user", value = "enabled", havingValue = "true")
    public UserClient userClient(UserProperties userProperties) {
        return new UserClient(userProperties);
    }
}
