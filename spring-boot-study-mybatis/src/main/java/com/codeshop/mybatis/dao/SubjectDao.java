package com.codeshop.mybatis.dao;

import com.codeshop.mybatis.domain.SubjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectDao {

    SubjectDO get(Integer id);
}
