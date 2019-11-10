package com.codeshop.jpa.service;

import com.codeshop.jpa.dao.UserDao;
import com.codeshop.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 插入
     * @param userEntity
     */
    public void addUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    /**
     * 修改
     * @param userEntity
     */
    public void updateUser(UserEntity userEntity) {
        userDao.save(userEntity);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    public UserEntity findUserById(Long id) {
        return userDao.findById(id).get();
    }

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    public List<UserEntity> findUsersByName(String name) {
        return userDao.findByNameLike(name);
    }
}
