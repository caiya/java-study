package com.codeshop.mybatis.controller;

import com.codeshop.mybatis.domain.UserDO;
import com.codeshop.mybatis.domain.dto.UserDTO;
import com.codeshop.mybatis.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Object getUsers(UserDTO userDTO) {
        return userService.list(userDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) {
        if (id == null) {
            return null;
        }
        return userService.get(Integer.valueOf(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody UserDO user) {
        if (user.getId() != null && user.getId() != 0) {
            return null;
        }
        userService.save(user);
        return user;
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Object editUser(@RequestBody UserDO user) {
        userService.update(user);
        return user;
    }

    @DeleteMapping("{ids}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("ids") String ids) {
//        userService.remove(Integer.valueOf(id));
        Integer[] idArray = new Integer[ids.split(",").length];
        for(int i = 0, len = ids.split(",").length; i < len; i++) {
            idArray[i] = Integer.valueOf(ids.split(",")[i]);
        }
        userService.batchRemove(idArray);
    }
}
