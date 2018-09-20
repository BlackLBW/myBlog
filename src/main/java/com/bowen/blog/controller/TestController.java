package com.bowen.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by libowen on 2018/7/9.
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public Object login() {
        return "login";
    }
}
