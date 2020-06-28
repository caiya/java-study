package com.caiya.business.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author caiya
 * @date 2020/6/21 22:04
 * @description
 */
public interface BaseService<R extends BaseMapper<ID>, V extends IdOnlyVO<ID>, ID extends Serializable> {
    /**
     * 根据id查找
     * @param id id主键
     * @return V
     */
    V findById(ID id);

    /**
     * 保存
     * @param vo vo实体
     * @return V
     */
    V saveOne(V vo);

    /**
     * 批量保存
     * @param voList vo实体列表
     */
    void batchSave(List<V> voList);

    /**
     * 删除
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(ID id);

    /**
     * 批量删除
     * @param idList 主键集合
     */
    void batchDelete(List<ID> idList);
}
