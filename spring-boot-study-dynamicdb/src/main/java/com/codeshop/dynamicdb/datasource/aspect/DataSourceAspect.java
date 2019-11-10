package com.codeshop.dynamicdb.datasource.aspect;

import com.codeshop.dynamicdb.datasource.annotation.DataSourceAnnotation;
import com.codeshop.dynamicdb.datasource.config.DynamicContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Around("@annotation(com.codeshop.dynamicdb.datasource.annotation.DataSourceAnnotation) || @within(com.codeshop.dynamicdb.datasource.annotation.DataSourceAnnotation)")
    public Object dataSourcePointCutAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class targetClass = joinPoint.getTarget().getClass();
        Method method = methodSignature.getMethod();

        // 类的注解
        DataSourceAnnotation classDataSource = (DataSourceAnnotation)targetClass.getDeclaredAnnotation(DataSourceAnnotation.class);
        // 方法注解
        DataSourceAnnotation methodDataSource = method.getDeclaredAnnotation(DataSourceAnnotation.class);
        if (classDataSource != null || methodDataSource != null) {
            String value = "";
            if (methodDataSource != null) {
                value = methodDataSource.value();
            } else {
                value = classDataSource.value();
            }
            // 操作之前，设置数据源
            DynamicContext.setDataSource(value);
            logger.info("设置数据源：" + value);
        }
        try {
            return joinPoint.proceed();
        }finally {
            // 操作完成之后，清除数据源
            DynamicContext.clearDataSource();
            logger.info("清除数据源");
        }
    }
}
