package com.bowen.blog.controller;

import com.bowen.blog.proxy.BlogProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libowen on 2018/7/9.
 */
@RestController
public class TestController {
    @Autowired
    private BlogProxy blogProxy;

    @RequestMapping("/")
    public Object test() {
        return blogProxy.getBlogs();
    }
}
