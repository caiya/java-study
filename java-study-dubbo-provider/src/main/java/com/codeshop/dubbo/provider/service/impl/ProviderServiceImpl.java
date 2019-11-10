package com.codeshop.dubbo.provider.service.impl;

import com.codeshop.dubbo.provider.service.ProviderService;

/**
 * 服务提供者实现
 */
public class ProviderServiceImpl implements ProviderService {

    public String SayHello(String word) {
        return word;
    }
}
