package com.shashijie.cn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 无参构造函数
@AllArgsConstructor // 全部属性构造函数
public class Article {
    
    private String title;
    
    private String category;
    
    private String time;
    
    private String state;
}
