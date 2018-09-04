package com.bowen.blog.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by libowen on 2018/7/11.
 * 博客实体
 */
@Data
public class Blog {
    private int id;
    //标题
    private String title;
    //作者
    private String writer;
    //文章类型
    private String type;
    //文章梗概
    private String summary;
    //发表日期
    private Date publicDate;
    //更新日期
    private Date updateDate;
    //浏览数量
    private int reviewCount;
    //文章markDown格式
    private String blogMarkdown;
}
