package com.codeshop.aop.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     * 注意：@Around修饰的方法一定要将方法的返回值返回！本身相当于代理！
     */
    @Around("@annotation(com.codeshop.aop.annotation.LogAnnotation)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // 获取请求
            ServletRequestAttributes servletRequestAttributes = ( ServletRequestAttributes )RequestContextHolder.getRequestAttributes();
            //获取目标方法的参数信息
            Object[] obj = joinPoint.getArgs();
            //AOP代理类的信息
            joinPoint.getThis();
            //代理的目标对象
            joinPoint.getTarget();
            //用的最多 通知的签名
            Signature signature = joinPoint.getSignature();
            //代理的是哪一个方法
            logger.info("代理的是哪一个方法："+signature.getName());
            //AOP代理类的名字
            logger.info("AOP代理类的名字："+signature.getDeclaringTypeName());
            //AOP代理类的类（class）信息
            signature.getDeclaringType();
            //获取RequestAttributes
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            //如果要获取Session信息的话，可以这样写：
            HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
            logger.info("sessionId："+session.getId());
            //获取请求参数
            Enumeration<String> enumeration = request.getParameterNames();
            Map<String,String> parameterMap = new HashMap<>();
            while (enumeration.hasMoreElements()){
                String parameter = enumeration.nextElement();
                parameterMap.put(parameter,request.getParameter(parameter));
            }
            String str = JSON.toJSONString(parameterMap);
            if(obj.length > 0) {
                logger.info("请求的参数信息为："+str);
            }
            // 最后一定记得返回执行结果
            return joinPoint.proceed();
        }catch (Exception ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }
}
