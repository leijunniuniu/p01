package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    @Select("select * from user where username=#{username} and password=#{password}")
    public List<User> login(User user);

    //注册效验
    @Select("select * from user where username=#{username}")
    public User registerVerifyByUserName(@Param("username") String username);
}
