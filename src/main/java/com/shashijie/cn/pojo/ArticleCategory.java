package com.shashijie.cn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 无参构造函数
@AllArgsConstructor // 全部属性构造函数
public class ArticleCategory {
    
    private String id;
    
    private String categoryName;
    
    private String categoryAlias;
    
    private String createTime;
    
    private String updateTime;
}
