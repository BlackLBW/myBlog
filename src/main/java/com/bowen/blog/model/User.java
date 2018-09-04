package com.bowen.blog.model;

import lombok.Data;

/**
 * Created by libowen on 2018/7/12.
 * 用户数据
 */

@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private String userAvatar;
    private long lastLoginTime;

    public User(String userName, String password, String userAvatar, long lastLoginTime) {
        this.userName = userName;
        this.password = password;
        this.userAvatar = userAvatar;
        this.lastLoginTime = lastLoginTime;
    }
}
