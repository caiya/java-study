package com.caiya.demo.entity;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created By caiya
 * Date 2020/1/7 9:33
 * Description
 */
@Data
@Builder
@Accessors(chain = true)
@RequiredArgsConstructor(staticName = "of")
public class User {
    @NotNull
    private String username;

    private int age;

    private Integer id;

    private Date birthday;
}
