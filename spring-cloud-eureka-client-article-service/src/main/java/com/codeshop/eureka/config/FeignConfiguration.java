package com.codeshop.eureka.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign的日志配置
 */
@Configuration
public class FeignConfiguration {

    /**
     * 输出日志级别最高
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
