package com.codeshop.eureka.controller;

import com.codeshop.eureka.service.UserRemoteService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ArticleController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private UserRemoteService userRemoteService;

    @GetMapping("/article/callHello")
    public String callHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-client-user-service/user/hello", String.class);
        System.out.println(responseEntity.getHeaders());
        return responseEntity.getBody();
    }

    /**
     * 获取某服务的实例信息，浏览器调用测试该接口的话，会发现8081、8083是负载均衡的
     * @param serviceName
     * @return
     */
    @GetMapping("/service/{serviceName}")
    public Object getServiceInfo(@PathVariable(name = "serviceName", required = true) String serviceName) {
        return loadBalancerClient.choose(serviceName);
    }

    /**
     * 使用feign代替restTemplate进行http调用
     * @return
     */
    @GetMapping("/article/sayHello")
    public String sayHello() {
        return userRemoteService.hello();
    }
}
