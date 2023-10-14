package com.zht.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

public class ManagerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("type")&&cookie.getValue().equals("0")) {
                    return true;
                }
            }
        }

        if(request.getSession().getAttribute("MANAGER_SESSION")!=null){
            return true;
        }else{
            request.getRequestDispatcher("/jumpToError?errorCode=405").forward(request, response);
            return false;
        }
    }
}
