package org.example.employeesystem.service;

import org.example.employeesystem.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();
    boolean insert(Dept dept);
    boolean update(Dept dept);
    boolean deleteById(Integer id);
}
