package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器执行流程
 * MyInterceptorController01...preHandle
 * test01....
 * MyInterceptorController01...postHandle
 * index.jsp
 * MyInterceptorController01...afterCompletion
 * 目标方法错误执行流程：
 * MyInterceptorController01...preHandle
 * test01....
 * MyInterceptorController01...afterCompletion
 * 不放行执行流程：
 * MyInterceptorController01...preHandle
 */
@Controller
public class MyInterceptorController01 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptorController01...preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptorController01...postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptorController01...afterCompletion");
    }
}
