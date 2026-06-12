package org.example.employeesystem.controller;


import org.example.employeesystem.entity.Dept;
import org.example.employeesystem.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeptController {
    private final DeptService deptService;
    public DeptController(DeptService deptService){
        this.deptService = deptService;
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @PostMapping("/dept/insert")
    public Map<String, Object> insert(@RequestBody Dept dept){
        Map<String,Object> res = new HashMap<>();
        res.put("success",deptService.insert(dept));
        return res;
    }

    @PostMapping("/dept/update")
    public Map<String,Object> update(@RequestBody Dept dept){
        Map<String,Object> res = new HashMap<>();
        res.put("success",deptService.update(dept));
        return res;
    }

    @PostMapping("/dept/delete")
    public Map<String,Object>delete(@RequestBody Dept dept){
        Map<String,Object> res = new HashMap<>();
        res.put("success",deptService.deleteById(dept.getId()));
        return res;
    }
}
