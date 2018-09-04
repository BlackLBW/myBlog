package com.bowen.blog.dao;

import com.bowen.blog.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by libowen on 2018/7/11.
 */
@Mapper
public interface BlogMapper {
    String table_name = "blog";
    String column = "id, title, writer, type, summary, public_date, update_date ,review_count, blog_markdown";


    @Select(" select " + column + " from "+ table_name)
    public List<Blog> getBlogs();
}
