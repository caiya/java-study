package com.codeshop.spring.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncTaskExecutePool implements AsyncConfigurer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskThreadPoolConfig config;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(config.getCorePoolSize());
        executor.setMaxPoolSize(config.getMaxPoolSize());
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        executor.setQueueCapacity(config.getQueueCapacity());
        executor.setThreadNamePrefix(config.getThreadNamePrefix());
        // 拒绝策略：队列任务满后，使用主线程执行，保证任务不丢弃
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                logger.error("exception method: " + method.getName());
                logger.error("############" + ex.getMessage() + "############", ex);
            }
        };
    }
}
