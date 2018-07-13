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
}
