package org.example.employeesystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.employeesystem.entity.Emp;

import java.util.List;


@Mapper
public interface  EmpMapper {
    List<Emp> selectAll();
    Emp selectById(Integer id);
    int insert(Emp emp);
    int update(Emp emp);
    int delete(Integer id);
    List<Emp> selectByName(String name);
    List<Emp> selectPage(@Param("offset")int offset,@Param("size")int size);
    int count();
}
