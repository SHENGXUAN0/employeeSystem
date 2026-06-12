package org.example.employeesystem.controller;


import org.example.employeesystem.entity.Emp;
import org.example.employeesystem.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    private final EmpService empService;
    public EmpController(EmpService empService) {
        this.empService = empService;
    }
    @GetMapping("/emp/list")
    public List<Emp> list(){
        return empService.list();
    }
    @GetMapping("/emp/get")
    public Emp getById(Integer id){
        return empService.getById(id);
    }

    @PostMapping("/emp/add")
    public boolean add(@RequestBody Emp emp){
        return empService.add(emp);
    }

    @PostMapping("/emp/update")
    public boolean update(@RequestBody Emp emp){
        return empService.update(emp);
    }

    @PostMapping("/emp/delete")
    public boolean delete(Integer id){
        return empService.delete(id);
    }

    @PostMapping("/emp/search")
    public List<Emp> search(String name){
        return empService.search(name);
    }

    @GetMapping("/emp/page")
    public List<Emp> page(int page,int size){
        return empService.page(page,size);
    }

    @GetMapping("/emp/count")
    public int count(){
        return empService.count();
    }


}
