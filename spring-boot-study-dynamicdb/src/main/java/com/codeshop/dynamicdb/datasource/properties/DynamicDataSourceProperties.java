package com.codeshop.dynamicdb.datasource.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 多数据源属性
 */
@ConfigurationProperties(prefix = "dynamic")
@Data
public class DynamicDataSourceProperties {
    private Map<String, DataSourceProperties> datasource = new LinkedHashMap<>();
}
