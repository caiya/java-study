package com.caiya.delegate.core;

import com.caiya.delegate.DynamicDelegateApplication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.util.StringUtils;

public class ProxyRegister implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        boolean annotationPresent = DynamicDelegateApplication.class.isAnnotationPresent(EnableProxy.class);
        if (annotationPresent) {
            EnableProxy annotation = DynamicDelegateApplication.class.getAnnotation(EnableProxy.class);
            String basePackage = annotation.basePackage();
            if (StringUtils.isEmpty(basePackage)) {
                return;
            }
            ServiceInterfacesScanner scanner = new ServiceInterfacesScanner(beanDefinitionRegistry);
            scanner.doScan(basePackage);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
