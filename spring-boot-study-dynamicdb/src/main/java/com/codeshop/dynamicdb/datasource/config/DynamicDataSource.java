package com.codeshop.dynamicdb.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源需要继承AbstractRoutingDataSource，重写determineCurrentLookupKey方法
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 获取当前数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicContext.getDataSource();
    }
}
