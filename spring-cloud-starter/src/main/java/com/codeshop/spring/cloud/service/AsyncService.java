package com.codeshop.spring.cloud.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {

    @Async
    public Future<String> saveLog() {
        System.out.println("currentThread: " + Thread.currentThread().getName());
        return new AsyncResult<>(Thread.currentThread().getName());
    }
}
