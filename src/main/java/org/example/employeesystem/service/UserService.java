package org.example.employeesystem.service;

import org.example.employeesystem.entity.User;

public interface UserService {
    User login(User user);
    boolean register(User user);
}
