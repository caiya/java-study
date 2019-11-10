package com.codeshop.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionController {
    private Integer count = 0;

    @GetMapping("/session")
    @ResponseBody
    public Object getSession(HttpServletRequest request) {
        request.getSession().setAttribute("username", "Coding杂货铺");
        request.getSession().setAttribute("count", count++);
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("username", request.getSession().getAttribute("username"));
        map.put("count", request.getSession().getAttribute("count"));
        return map;
    }
}
