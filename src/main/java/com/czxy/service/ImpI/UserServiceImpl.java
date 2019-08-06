package com.czxy.service.ImpI;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        List<User> login = userMapper.login(user);
        return login.isEmpty()?null:login.get(0);
    }

    @Override
    public User registerVerifyByUserName(String username) {
        return userMapper.registerVerifyByUserName(username);
    }





    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteByPrimaryKey(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
