package org.example.employeesystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.employeesystem.entity.User;

@Mapper
public interface UserMapper {
    User login(User user);
    int register(User user);
}
