package org.example.employeesystem.controller;


import jakarta.servlet.http.HttpSession;
import org.example.employeesystem.entity.User;
import org.example.employeesystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user , HttpSession session){
        Map<String,Object> res = new HashMap<>();
        User loginUser = userService.login(user);
        if(loginUser == null){
            res.put("success",false);
            res.put("msg","用户名或者密码错误");
        }else{
            session.setAttribute("loginUser",loginUser);
            res.put("success",true);
            res.put("msg","登陆成功");

        }
        return res;
    }

    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        Map<String,Object> res = new HashMap<>();
        boolean success = userService.register(user);
        if(success){
            res.put("success",true);
            res.put("msg","注册成功");
        }else{
            res.put("success",false);
            res.put("msg","注册失败");
        }
        return res;
    }
    @PostMapping("/logout")
    public Map<String,Object> logout(HttpSession session){
        Map<String,Object> res = new HashMap<>();
        session.removeAttribute("loginUser");
        res.put("success",true);
        res.put("msg","退出成功");
        return res;
    }
}
