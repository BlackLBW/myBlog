package com.bowen.blog.biz;

import cn.hutool.core.date.DateUtil;
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

    public int updateUserLoginTime(int id) {
        return userMapper.updateUserLoginTime(DateUtil.date().getTime(), id);
    }

    public void insertUser(String userName, String password, String userAvatar) {
        User user = new User(userName, password, userAvatar, DateUtil.date().getTime());
        userMapper.insertUser(user);
    }

}
