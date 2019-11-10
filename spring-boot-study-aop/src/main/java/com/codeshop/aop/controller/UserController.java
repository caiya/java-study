package com.codeshop.aop.controller;

import com.codeshop.aop.annotation.LogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {

    @LogAnnotation
    @GetMapping("/userInfo")
    @ResponseBody
    public Object userInfo() {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("userName", "codeshop");
        userInfo.put("age", 18);
        userInfo.put("address", "北京市前海大街605号");
        return userInfo;
    }
}
