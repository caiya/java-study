package com.codeshop.mybatis.service.impl;

import com.codeshop.mybatis.dao.UserDao;
import com.codeshop.mybatis.domain.UserDO;
import com.codeshop.mybatis.domain.dto.UserDTO;
import com.codeshop.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDO get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<UserDO> list(UserDTO userDTO) {
        return userDao.list(userDTO);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public void save(UserDO userDO) {
        userDao.save(userDO);
    }

    @Override
    public void update(UserDO userDO) {
        userDao.update(userDO);
    }

    @Override
    public void remove(Integer id) {
        userDao.remove(id);
    }

    @Override
    public void batchRemove(Integer[] ids) {
        userDao.batchRemove(ids);
    }
}
