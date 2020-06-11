package com.caiya.delegate.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 定义代理类的实现工厂
 * @param <T>
 */
public class ServiceProxyFactoryBean<T> implements FactoryBean<T> {
    private Class<T> interfaces;

    public ServiceProxyFactoryBean(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces}, new ServiceProxy<>(interfaces));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
