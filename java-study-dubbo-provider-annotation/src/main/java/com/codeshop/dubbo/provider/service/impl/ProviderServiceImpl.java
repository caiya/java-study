package com.codeshop.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.codeshop.dubbo.provider.service.ProviderService;

/**
 * @Service 用来标识服务提供方，executes用于限制并发为10
 * connections = 10，限制客户端使用连接数最大10
 */
@Service(timeout = 5000, version = "1.0.0", executes = 10, connections = 10, retries = 2, cluster = "failover")
public class ProviderServiceImpl implements ProviderService {

    public String SayHello(String word) {
        return word;
    }
}
