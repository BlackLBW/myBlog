package com.bowen.blog.proxy;

import com.bowen.blog.biz.BlogBiz;
import com.bowen.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by libowen on 2018/7/11.
 */
@Service
public class BlogProxy {

    @Autowired
    private BlogBiz blogBiz;

    public List<Blog> getBlogs() {
        return blogBiz.getBlogs();
    }
}
