package com.codeshop.dynamicdb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
    private Integer sex;
    private Date lastLoginTime;
}
