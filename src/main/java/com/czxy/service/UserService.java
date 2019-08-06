package com.czxy.service;

import com.czxy.domain.User;

public interface UserService {
    public User login(User user);
    //修改
    public void update(User user);
    //根据主键删除
    public void deleteByPrimaryKey(String id);
    //根据主键查询
    public User selectByPrimaryKey(String id);
    //添加
    public void insert(User user);

    public User registerVerifyByUserName(String username);
}
