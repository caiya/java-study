package com.codeshop.jpa.dao;

import com.codeshop.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    List<UserEntity> findByNameLike(String name);
}
