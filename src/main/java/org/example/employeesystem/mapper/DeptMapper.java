package org.example.employeesystem.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.employeesystem.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    List<Dept> selectAll();
    int insert(Dept dept);
    int update(Dept dept);
    int deleteById(Integer id);
}
