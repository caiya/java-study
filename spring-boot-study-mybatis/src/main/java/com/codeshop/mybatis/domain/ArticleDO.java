package com.codeshop.mybatis.domain;

import java.util.Date;

// 文章实体
public class ArticleDO {
    private Integer id;
    private String title;
    private String content;
    private Date createTime;

    private Integer userId;

    /**
     * 所属用户
     */
    private UserDO user;

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
