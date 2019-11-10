package com.codeshop.dynamicdb.service.impl;

import com.codeshop.dynamicdb.dao.UserDao;
import com.codeshop.dynamicdb.datasource.annotation.DataSourceAnnotation;
import com.codeshop.dynamicdb.domain.UserDO;
import com.codeshop.dynamicdb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDO get(Integer id) {
        return userDao.get(id);
    }

    @DataSourceAnnotation("slave1")
    @Override
    public UserDO get2(Integer id) {
        return userDao.get(id);
    }
}
