package com.caiya.business.base;

import lombok.Data;

/**
 * @author caiya
 * @date 2020/6/21 22:19
 * @description
 */
@Data
public class IdOnlyEntity<T> {
    private T id;
}
