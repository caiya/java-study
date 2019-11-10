package com.codeshop.dynamicdb.controller;

import com.codeshop.dynamicdb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) {
        if (id == null) {
            return null;
        }
        return userService.get(Integer.valueOf(id));
    }

    @GetMapping("/info2/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser2(@PathVariable("id") String id) {
        if (id == null) {
            return null;
        }
        return userService.get2(Integer.valueOf(id));
    }
}
