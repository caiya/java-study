package com.codeshop.mybatis.controller;

import com.codeshop.mybatis.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getArticle(@PathVariable("id") String id) {
        return articleService.get(Integer.valueOf(id));
    }
}
