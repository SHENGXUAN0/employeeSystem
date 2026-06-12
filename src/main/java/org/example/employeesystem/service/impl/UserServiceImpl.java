package org.example.employeesystem.service.impl;

import org.example.employeesystem.entity.User;
import org.example.employeesystem.mapper.UserMapper;
import org.example.employeesystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public boolean register(User user) {
        return userMapper.register(user) > 0;
    }
}
