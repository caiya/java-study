package com.codeshop.dubbo.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableDubbo(scanBasePackages = "com.codeshop.dubbo.consumer.service")
@ComponentScan(value = {"com.codeshop.dubbo.consumer"})
public class ConsumerConfiguration {

    /**
     * 应用配置
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-annotation");
        Map<String, String> params = new HashMap<String, String>();
        params.put("qos.enable", "true");
        params.put("qos.accept.foreign.ip", "false");
        params.put("qos.port", "33333");
        applicationConfig.setParameters(params);
        return applicationConfig;
    }

    /**
     * 服务消费者配置
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

    /**
     * 注册中心配置
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("localhost");
        registryConfig.setPort(2181);
        return registryConfig;
    }
}
