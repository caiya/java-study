package com.codeshop.mybatis.dao;

import com.codeshop.mybatis.domain.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {

    ArticleDO get(Integer id);
}
