package com.zht.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Cookie[] cookies = request.getCookies();


        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("type")) {
                    return true;
                }
            }
        }

        if((request.getSession().getAttribute("USER_SESSION")!=null)
                ||(request.getSession().getAttribute("MANAGER_SESSION")!=null)){
            System.out.println("nihao2");
            return true;
        }

        response.sendRedirect("/jumpTologin");
        //response.sendRedirect("/");
        return true;
    }
}
