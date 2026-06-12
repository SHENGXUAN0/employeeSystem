package org.example.employeesystem.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.employeesystem.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
            HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute("loginUser");
            if(loginUser == null){
                response.setStatus(401);
                response.getWriter().write("please login");
                return false;
            }
            if(!"admin".equals(loginUser.getRole())){
                response.setStatus(403);
                response.getWriter().write("you don't have permission");
                return false;
            }
            return true;
        }

    }


