package com.codeshop.mybatis.service;

import com.codeshop.mybatis.domain.UserDO;
import com.codeshop.mybatis.domain.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {

    UserDO get(Integer id);

    List<UserDO> list(UserDTO userDTO);

    int count(Map<String, Object> map);

    void save(UserDO userDO);

    void update(UserDO userDO);

    void remove(Integer id);

    void batchRemove(Integer[] ids);

}
