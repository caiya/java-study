package com.codeshop.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object submit(@RequestParam String userName, @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();

        // 封装一个UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 委托给subject.login
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result.put("code", 0);
            result.put("msg", "登录成功");
            return result;
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            result.put("code", -1);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }

    /**
     * 需要认证通过才能访问
     * @param modelMap
     * @return
     */
    @GetMapping("/index")
    @RequiresAuthentication
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userName", "admin");
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    /**
     * 需要权限system:users:add才可以访问
     * @return
     */
    @GetMapping("/user/add")
    @RequiresPermissions("system:users:add")
    public String userAdd() {
        return "userAdd";
    }

    @GetMapping("/user/edit")
    @RequiresPermissions("system:users:edit")
    public String userEdit() {
        return "userEdit";
    }

    @GetMapping("/user/remove")
    @RequiresPermissions("system:users:remove")
    public String userRemove() {
        return "userRemove";
    }

    @GetMapping("/user/list")
    @RequiresPermissions("system:users:list")
    public String userList() {
        return "userList";
    }

    @GetMapping("/user/noauth")
    @RequiresPermissions("system:users:noauth")
    public String noauth() {
        return "login";
    }
}
