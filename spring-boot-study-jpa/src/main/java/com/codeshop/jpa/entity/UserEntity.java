package com.codeshop.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "sys_user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 32)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 3)
    private Integer age;
}
