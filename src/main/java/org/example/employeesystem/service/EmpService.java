package org.example.employeesystem.service;

import org.example.employeesystem.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> list();
    Emp getById(Integer id);
    boolean add(Emp emp);
    boolean update(Emp emp);
    boolean delete(Integer id);
    List<Emp> search(String name);
    List<Emp> page(int page, int size);
    int count();
}
