package com.bowen.blog.biz;

import com.bowen.blog.dao.UserMapper;
import com.bowen.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by libowen on 2018/7/12.
 */
@Service
public class UserBiz {

    @Autowired
    private UserMapper userMapper;

    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }
}
