package com.shashijie.cn.controller;

import com.shashijie.cn.pojo.ArticleCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端VUE通过Axios发送数据请求,这里controller接收请求返回结果
 */
@Slf4j
@RestController
@RequestMapping("/articleCategoryController")
@CrossOrigin //支持跨域
public class ArticleCategoryController {
    
    /*通常是数据库中获取List集合*/
    private List<ArticleCategory> articleList = new ArrayList<>();
    
    {
        articleList.add(new ArticleCategory("1", "美食", "ms", "2024-09-02 12:06:59", "2023-09-02 12:06:59"));
        articleList.add(new ArticleCategory("2", "娱乐", "yl", "2024-09-02 12:06:59", "2023-09-02 12:06:59"));
        articleList.add(new ArticleCategory("3", "军事", "js", "2024-09-02 12:06:59", "2023-09-02 12:06:59"));
        articleList.add(new ArticleCategory("4", "人文", "rw", "2024-09-02 12:06:59", "2023-09-02 12:06:59"));
    }
    
    @RequestMapping("/add")
    public String add(@RequestBody ArticleCategory article) {
        articleList.add(article);
        return "新增成功";
    }
    
    @RequestMapping("/getAll")
    public List<ArticleCategory> getAll() {
        return articleList;
    }
    
}
