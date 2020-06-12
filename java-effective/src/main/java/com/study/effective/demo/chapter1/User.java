package com.study.effective.demo.chapter1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Created By caiya
 * Date 2020/3/2 23:51
 * Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;
    // 属性超过4个，启用builder

    public static User of(String name, Integer age) {
        return new User(name, age);
    }
}


