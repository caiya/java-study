package com.codeshop.dynamicdb.datasource.config;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 多数据源上下文切换
 */
public class DynamicContext {
    private static final ThreadLocal<ArrayDeque<String>> CONTEXT_HOLDER = ThreadLocal.withInitial(() -> new ArrayDeque());

    /**
     * 获取当前数据源
     * @return
     */
    public static String getDataSource() {
        return CONTEXT_HOLDER.get().peek();
    }

    /**
     * 设置当前数据源
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        CONTEXT_HOLDER.get().push(dataSource);
    }

    /**
     * 清空数据源
     */
    public static void clearDataSource() {
        Deque<String> deque = CONTEXT_HOLDER.get();
        deque.poll();
    }
}
