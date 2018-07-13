package com.bowen.blog.dao;

import com.bowen.blog.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by libowen on 2018/7/12.
 */
public interface UserMapper {

    String tableName = "user";
    String column = "id, user_name, password, user_avatar, last_login_time";

    @Select(" select " + column + " from " + tableName + " where user_name=#{userName}")
    public User getUserByName(String userName);
}
