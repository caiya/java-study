package com.codeshop.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.codeshop.dubbo.provider.service.ProviderService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @Reference(version = "1.0.0")
    private ProviderService providerService;

    public String doSayHello(String word) {
        return providerService.SayHello(word);
    }
}
