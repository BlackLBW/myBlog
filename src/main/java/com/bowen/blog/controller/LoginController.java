package com.bowen.blog.controller;

import com.bowen.blog.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libowen on 2018/7/12.
 * 后台管理系统登录界面
 */

@RestController
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    private UserProxy userProxy;

    @RequestMapping(value = "/login")
    public Object login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "password") String password) {
        return userProxy.login(userName, password);
    }

    @RequestMapping(value = "/regist")
    public Object regist() {

        return null;
    }
}
