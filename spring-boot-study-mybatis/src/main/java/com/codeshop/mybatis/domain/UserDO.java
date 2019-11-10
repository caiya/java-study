package com.codeshop.mybatis.domain;

import java.util.Date;
import java.util.List;

// 用户类实体，和文章ArticleDO实体是1对N的关系，和科目SubjectDO是N对N的关系
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
    private Integer sex;
    private Date lastLoginTime;

    /**
     * 当前用户的所有科目
     */
    private List<SubjectDO> subjects;

    /**
     * 文章集合
     */
    private List<ArticleDO> articles;

    public List<SubjectDO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDO> subjects) {
        this.subjects = subjects;
    }

    public List<ArticleDO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDO> articles) {
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
