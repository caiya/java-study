package com.codeshop.dynamicdb.service;

import com.codeshop.dynamicdb.domain.UserDO;

public interface UserService {

    UserDO get(Integer id);

    UserDO get2(Integer id);
}
