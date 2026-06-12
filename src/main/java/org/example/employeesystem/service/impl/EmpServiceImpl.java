package org.example.employeesystem.service.impl;


import org.example.employeesystem.entity.Emp;
import org.example.employeesystem.mapper.EmpMapper;
import org.example.employeesystem.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public List<Emp> list(){
        return empMapper.selectAll();
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.selectById(id);
    }

    @Override
    public boolean add(Emp emp){
        return empMapper.insert(emp) > 0;
    }
    @Override
    public boolean update(Emp emp){
        return empMapper.update(emp) > 0;
    }
    @Override
    public boolean delete(Integer id){
        return empMapper.delete(id) > 0;
    }
    @Override
    public List<Emp> search(String name){
        return empMapper.selectByName(name);
    }
    @Override
    public List<Emp> page(int page, int size){
        int offset = (page - 1) * size;
        return empMapper.selectPage(offset,size);
    }
    @Override
    public int count(){
        return empMapper.count();
    }
}
