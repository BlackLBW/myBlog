package com.bowen.blog.dao;

import com.bowen.blog.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by libowen on 2018/7/12.
 */
@Mapper
public interface UserMapper {

    String tableName = "user";
    String column = " id, user_name, password, user_avatar, last_login_time ";

    @Select(" select " + column + " from " + tableName + " where user_name=#{0}")
    User getUserByName(String userName);

    @Update(" update " + tableName + " set last_login_time=#{0} where id=#{1} ")
    int updateUserLoginTime(long lastLoginTime, int id);

    @Insert(" insert into " + tableName + " ( " + column + " ) " + " values ( null, #{userName}, #{password}, #{userAvatar}, #{lastLoginTime})")
    void insertUser(User user);
}
