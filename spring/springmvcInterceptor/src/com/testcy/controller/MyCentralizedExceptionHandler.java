package com.testcy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理异常的类
 * 1、将集中处理异常的类加入IOC容器中
 */
@ControllerAdvice
public class MyCentralizedExceptionHandler {

    /*@ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView handleException02(Exception e){
        System.out.println("全局handleException01..."+e);
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg", e);
        return view;
    }*/

 /*   @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException01(Exception e){
        System.out.println("全局的handleException01..."+e);
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg", e);
        return view;
    }*/

}
