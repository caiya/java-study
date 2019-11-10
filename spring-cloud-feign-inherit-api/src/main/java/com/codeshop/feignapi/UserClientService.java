package com.codeshop.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "feign-inherit-provider")
public interface UserClientService {

    @GetMapping(value = "/user/name")
    String getName(@RequestParam("name") String name);
}
