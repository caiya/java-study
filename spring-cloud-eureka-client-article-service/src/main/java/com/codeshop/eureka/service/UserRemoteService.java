package com.codeshop.eureka.service;

import com.codeshop.eureka.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用openfeign进行声明式http调用
 */
@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration.class)
public interface UserRemoteService {

    @GetMapping("/user/hello")
    String hello();
}
