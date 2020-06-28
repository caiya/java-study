package com.caiya.business.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author caiya
 * @date 2020/6/21 22:35
 * @description
 */
public abstract class BaseServiceImpl<R extends BaseMapper<ID>, V extends IdOnlyVO<ID>, ID extends Serializable> implements BaseService<R, V, ID> {
    private R repository;

    @Override
    public V findById(ID id) {
        return null;
    }

    @Override
    public V saveOne(V vo) {
        return null;
    }

    @Override
    public void batchSave(List<V> voList) {

    }

    @Override
    public boolean deleteById(ID id) {
        return false;
    }

    @Override
    public void batchDelete(List<ID> idList) {

    }
}
