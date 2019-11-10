package com.codeshop.dynamicdb.dao;

import com.codeshop.dynamicdb.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    UserDO get(Integer id);
}
