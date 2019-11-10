package com.codeshop.spring.starter.demo.annotation;

import com.codeshop.spring.starter.demo.UserAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 是否自动配置
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({UserAutoConfigure.class})
public @interface EnableUserClient {
}
