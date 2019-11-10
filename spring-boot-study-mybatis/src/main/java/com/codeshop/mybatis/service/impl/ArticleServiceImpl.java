package com.codeshop.mybatis.service.impl;

import com.codeshop.mybatis.dao.ArticleDao;
import com.codeshop.mybatis.domain.ArticleDO;
import com.codeshop.mybatis.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Override
    public ArticleDO get(Integer id) {
        return articleDao.get(id);
    }
}
