package org.example.employeesystem.service.impl;

import org.example.employeesystem.entity.Dept;
import org.example.employeesystem.mapper.DeptMapper;
import org.example.employeesystem.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;
    public DeptServiceImpl(DeptMapper deptMapper){
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> list() {
        return deptMapper.selectAll();
    }

    @Override
    public boolean insert(Dept dept) {
        return deptMapper.insert(dept) > 0;
    }

    @Override
    public boolean update(Dept dept) {
        return deptMapper.update(dept) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return deptMapper.deleteById(id) > 0;
    }
}
