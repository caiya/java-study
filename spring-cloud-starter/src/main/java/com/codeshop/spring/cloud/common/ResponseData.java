package com.codeshop.spring.cloud.common;

import lombok.Data;

@Data
public class ResponseData {
    private boolean status = true;
    private int code = 200;
    private String message;
    private Object data;
}
