package com.caiya.delegate.core;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({ProxyRegister.class})
@Documented
public @interface EnableProxy {
    String basePackage() default "";
}
