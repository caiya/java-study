package com.codeshop.mybatis.domain;

import java.util.List;

// 科目实体
public class SubjectDO {
    private Integer id;
    private String name;

    /**
     * 科目关联的所有用户
     */
    private List<UserDO> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDO> users) {
        this.users = users;
    }
}
