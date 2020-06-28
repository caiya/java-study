package com.caiya.business.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author caiya
 * @date 2020/6/21 22:18
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IdEntity<T> extends IdOnlyEntity<T> {
    private Date createTime;
    private Date modifyTime;
    private T createdBy;
    private T modifiedBy;
}
