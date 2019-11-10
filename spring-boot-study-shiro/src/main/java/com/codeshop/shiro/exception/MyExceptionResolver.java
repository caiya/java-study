package com.codeshop.shiro.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果这里不配置异常拦截的的话，shiro没权限时只会报控制台错误不会跳转到/403
 */
@ControllerAdvice
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof UnauthorizedException) {
            ModelAndView mv = new ModelAndView("/error/403");
            return mv;
        }
        return null;
    }
}
