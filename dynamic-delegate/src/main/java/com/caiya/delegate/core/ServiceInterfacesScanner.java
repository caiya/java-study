package com.caiya.delegate.core;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.Set;

/**
 * 自定义接口扫描类
 */
public class ServiceInterfacesScanner extends ClassPathBeanDefinitionScanner {

    public ServiceInterfacesScanner(BeanDefinitionRegistry registry) {
        // false表示不使用ClassPathBeanDefinitionScanner默认的TypeFilter
        super(registry, false);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        this.addFilter();
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        if (beanDefinitionHolders.isEmpty()) {
            throw new NullPointerException("No Interfaces");
        }
        this.createBeanDefinition(beanDefinitionHolders);
        return beanDefinitionHolders;
    }

    private void createBeanDefinition(Set<BeanDefinitionHolder> beanDefinitionHolders) {
        for (BeanDefinitionHolder beanDefinitionHolder: beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            // 将bean的真实类型改为 FactoryBean
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(ServiceProxyFactoryBean.class);
            beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        }
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        String[] interfaceNames = metadata.getInterfaceNames();
        return metadata.isInterface() && metadata.isIndependent() && Arrays.asList(interfaceNames).contains(BaseService.class.getName());
    }

    private void addFilter() {
        addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
    }
}
