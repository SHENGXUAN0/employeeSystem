package org.example.employeesystem.config;

import org.example.employeesystem.interceptor.AdminInterceptor;
import org.example.employeesystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login",
                                    "/register",
                                    "/logout",
                                    "/login.html",
                                    "/register.html",
                                    "/css/**",
                                    "/js/**",
                                    "/error"
                        );
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/emp/add",
                                "/emp/update",
                                "/emp/delete",
                                "/dept/insert",
                                "/dept/update",
                                "/dept/delete"

                );


    }
}
