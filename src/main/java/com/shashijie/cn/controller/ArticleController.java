package com.shashijie.cn.controller;

import com.shashijie.cn.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 前端VUE通过Axios发送数据请求,这里controller接收请求返回结果
 */
@Slf4j
@RestController
@RequestMapping("/articleController")
@CrossOrigin //支持跨域
public class ArticleController {
    
    /*通常是数据库中获取List集合*/
    private List<Article> articleList = new ArrayList<>();
    
    {
        articleList.add(new Article("医疗反腐绝非砍医护收入", "时事", "2023-09-05", "已发布"));
        articleList.add(new Article("中国劈篮缘何一败涂地?", "篮球", "2023-09-05", "草稿"));
        articleList.add(
                new Article("华山景区已受大风影响阵风达7-8级,未来24小时将持续", "旅游", "2023-09-07", "已发布"));
    }
    
    /**
     * 新增文章
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestBody Article article) {
        articleList.add(article);
        return "新增成功";
    }
    
    /**
     * 获取所有文章信息
     * @return
     */
    @RequestMapping("/getAll")
    public List<Article> getAll() {
        return articleList;
    }
    
    /**
     * 根据文章分类和发布状态搜索
     */
    @RequestMapping("/search")
    public List<Article> search(@RequestBody Article article) {
        String category = article.getCategory();
        String state = article.getState();
        List<Article> resultList = new ArrayList<>(articleList);
        if (!StringUtils.isEmpty(category)) {
            resultList = resultList.stream().filter(a -> a.getCategory().equals(category)).collect(Collectors.toList());
        }
        if (!StringUtils.isEmpty(state)) {
            resultList = resultList.stream().filter(a -> a.getState().equals(state)).collect(Collectors.toList());
        }
        /* articleList.stream().filter(a -> a.getCategory().equals(category) && a.getState().equals(state)).collect
        (Collectors.toList());*/
        return resultList;
    }
    
}
