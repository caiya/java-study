package com.codeshop.spring.cloud.controller;

import com.codeshop.spring.cloud.config.MyConfig;
import com.codeshop.spring.cloud.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HelloController {

    // 读取配置文件方法1
    @Autowired
    private Environment env;

    // 读取配置文件方法2
    @Value("${server.port}")
    private String port;

    // 读取自定义配置
    @Autowired
    private MyConfig myConfig;

    @Resource
    private AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() throws ExecutionException, InterruptedException {
        System.out.println("port: " + port);
        System.out.println(myConfig.getEmail() + " " + myConfig.getName());

        // 异步任务测试
        Future<String> future = asyncService.saveLog();
        // 异步任务等待执行结束，使用循环
        while (future.isDone()) {
            String result = future.get();
            System.out.println("result: " + result);
            // 一定要记得break！！！
            break;
        }

        return env.getProperty("server.port");
    }
}
