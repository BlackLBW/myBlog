package com.bowen.blog.biz;

import com.bowen.blog.dao.BlogMapper;
import com.bowen.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by libowen on 2018/7/11.
 */
@Service
public class BlogBiz {

    @Autowired
    private BlogMapper blogMapper;

    public List<Blog> getBlogsByWriter(String writer) {
        return blogMapper.getBlogsByWriter(writer);
    }
}
