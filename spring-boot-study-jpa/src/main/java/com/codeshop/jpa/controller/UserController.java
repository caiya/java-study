package com.codeshop.jpa.controller;

import com.codeshop.jpa.entity.UserEntity;
import com.codeshop.jpa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody UserEntity user) {
        userService.addUser(user);
        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object deleteUser(@PathVariable(name = "id", required = true) Long id) {
        userService.deleteUserById(id);
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object updateUser(@RequestBody UserEntity user) {
        userService.updateUser(user);
        return null;
    }

    @GetMapping
    public Object findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Object findUserById(@PathVariable(name = "id", required = true) Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/findUsersWithName")
    public Object findAllUsersByName(String name) {
        return userService.findUsersByName(name);
    }
}
