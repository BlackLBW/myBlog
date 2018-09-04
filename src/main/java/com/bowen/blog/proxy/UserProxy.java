package com.bowen.blog.proxy;

import com.bowen.blog.biz.UserBiz;
import com.bowen.blog.model.Result;
import com.bowen.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by libowen on 2018/7/12.
 */
@Service
public class UserProxy {

    @Autowired
    private UserBiz userBiz;

    public Object login(String userName, String password) {

        User user = userBiz.getUserByName(userName);

        if (user != null && password.equals(user.getPassword())) {
            userBiz.updateUserLoginTime(user.getId());
            return Result.success();
        } else {
            return Result.paramInvalid("用户不存在");
        }

    }

}
