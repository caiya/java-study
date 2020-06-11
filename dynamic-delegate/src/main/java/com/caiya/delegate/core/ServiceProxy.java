package com.caiya.delegate.core;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 代理类
 * @param <T>
 */
@Slf4j
public class ServiceProxy<T> implements InvocationHandler {
    private Class<T> interfaces;

    public ServiceProxy(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("method: {}", method.getName());
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter: parameters) {
            log.info("param name: {}", parameter.getName());
            log.info("param value: {}", args);
        }
        return null;
    }
}
