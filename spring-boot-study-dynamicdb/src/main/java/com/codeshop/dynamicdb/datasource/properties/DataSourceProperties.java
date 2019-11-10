package com.codeshop.dynamicdb.datasource.properties;

import lombok.Data;

@Data
public class DataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    /**
     * Druid默认参数
     */
    private int initialSize = 2;
    private int maxActive = 20;
    private int minIdle = 2;
    private long maxWait = 60 * 1000L;
    private long timeBetweenEvictionRunsMillis = 60 * 1000L;
    private long minEvictableIdleTimeMillis = 1000L * 60L * 30L;
    private long maxEvictableIdleTimeMillis = 1000L * 60L * 60L * 7;
    private String validationQuery = "select 1 from dual";
    private int validationQueryTimeout = -1;
    private boolean testOnBorrow = true;
    private boolean testOnReturn = false;
    private boolean testWhileIdle = true;
    private boolean poolPreparedStatements = true;
    private int maxOpenPreparedStatements = -1;
    private boolean sharePreparedStatements = false;
    private String filters = "stat,wall";
}
