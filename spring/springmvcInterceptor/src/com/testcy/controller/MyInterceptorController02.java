package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 多个拦截器执行流程：按照配置顺序执行：先进后出
 * MyInterceptorController01...preHandle
 * MyInterceptorController02...preHandle
 * test01....
 * MyInterceptorController02...postHandle
 * MyInterceptorController01...postHandle
 * index.jsp
 * MyInterceptorController02...afterCompletion
 * MyInterceptorController01...afterCompletion
 *
 * 如果第二个拦截器不放行，那么已经放行的afterCompletion总会执行
 * MyInterceptorController01...preHandle
 * MyInterceptorController02...preHandle
 * MyInterceptorController01...afterCompletion
 */
@Controller
public class MyInterceptorController02 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptorController02...preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptorController02...postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptorController02...afterCompletion");
    }
}
