package com.caiya.business.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author caiya
 * @date 2020/6/21 22:17
 * @description
 */
@Data
public class IdOnlyVO<T> implements Serializable {
    private T id;
}
