package com.codeshop.spring.cloud.exception;

import com.codeshop.spring.cloud.common.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest request, Exception e) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(e.getMessage());
        if (e instanceof NoHandlerFoundException) {
            responseData.setCode(404);
        } else {
            responseData.setCode(500);
        }
        responseData.setData(null);
        responseData.setStatus(false);
        return responseData;
    }
}
