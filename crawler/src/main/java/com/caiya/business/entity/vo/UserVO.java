package com.caiya.business.entity.vo;

import com.caiya.business.base.IdVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author caiya
 * @date 2020/6/21 22:21
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends IdVO<Long> {
    private String name;
    private Integer age;
    private String email;
}
