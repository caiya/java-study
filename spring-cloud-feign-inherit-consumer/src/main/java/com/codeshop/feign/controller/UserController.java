package com.codeshop.feign.controller;

import com.codeshop.feignapi.UserClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserClientService userClientService;

    @GetMapping("/call")
    public String callHello(String name) {
        return userClientService.getName("callHello: " + name);
    }
}
