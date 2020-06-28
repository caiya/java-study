package com.caiya.business.entity;

import com.caiya.business.base.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author caiya
 * @date 2020/6/21 22:13
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserEntity extends IdEntity<Long> {
    private String name;
    private Integer age;
    private String email;
}
