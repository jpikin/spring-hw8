package com.example.shop_with_aspects.aspects;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    private long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        startTime = System.currentTimeMillis();
        System.out.println();

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView){
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Время работы метода: " + request.getRequestURI() + " " + endTime + " милисекунд");
        System.out.println("=====================================");
    }
}
