package com.codeshop.mybatis.domain.dto;

public class BaseDTO {
    private String sort = "id"; // 排序字段
    private String order = "desc"; // 排序方式

    private Integer page = 1;
    private Integer pageSize = 10;

    private Integer offset;
    private Integer limit;

    public Integer getLimit() {
        return pageSize;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
