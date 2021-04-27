package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingMatching {

    @RequestMapping("/antTest01")
    public String antTest01(){
        System.out.println("antTest01....");
        return "success";
    }

    /**
     * ?匹配一个字符，0或多个字符都不行，模糊和精确多个匹配下，精确优先
     * @return
     */
    @RequestMapping("/antTest0?")
    public String antTest02(){
        System.out.println("antTest02");
        return "success";
    }

    @RequestMapping("/antTest0*")
    public String antTest03(){
        System.out.println("antTest03");
        return "success";
    }

    /**
     * 匹配路径的多个字符，路径以a开头的任意多个字符，比如/atest/antTest01
     * @return
     */
    @RequestMapping("/a*/antTest01")
    public String antTest04(){
        System.out.println("antTest04");
        return "success";
    }

    /**
     * *可以匹配一层路径
     * @return
     */
    @RequestMapping("/a/*/antTest01")
    public String antTest05(){
        System.out.println("antTest05");
        return "success";
    }

    /**
     * **匹配多层路径
     * @return
     */
    @RequestMapping("/a/**/antTest01")
    public String antTest06(){
        System.out.println("antTest06");
        return "success";
    }

    /**
     * 路径参数
     * @return
     */
    @RequestMapping("/user/{id}")
    public String antTest07(@PathVariable("id") String id){
        System.out.println("路径上的占位符：id为"+id);
        return "success";
    }

    @RequestMapping("/{test}/{id}")
    public String antTest07(@PathVariable("test")String test,@PathVariable("id") String id){
        System.out.println("路径上的占位符：test为"+test);
        System.out.println("路径上的占位符：id为"+id);
        return "success";
    }

}
