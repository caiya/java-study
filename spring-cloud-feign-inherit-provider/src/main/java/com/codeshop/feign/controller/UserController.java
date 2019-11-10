package com.codeshop.feign.controller;

import org.springframework.web.bind.annotation.RestController;
import com.codeshop.feignapi.UserClientService;

@RestController
public class UserController implements UserClientService{

    @Override
    public String getName(String name) {
        return name;
    }
}
