package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("hello");
        return "../../hello";
    }

    /**
     * 转发：forward后面的转发地址，视图解析器默认不拼串，
     * 重定向：redirect:重定向路径
     * 注意：原生的servlet重定向，/路径必须带上项目名才能成功，
     * springmvc：/hello.jsp就是默认从当前项目名开始
     * @return
     */
    @RequestMapping(value = "/handle01")
    public String handle01(){
        System.out.println("handle01");
        return "forward:/hello.jsp";
    }

    @RequestMapping(value = "/handle02")
    public String handle02(){
        System.out.println("handle02");
        return "forward:/handle01";
    }
    @RequestMapping(value = "/handle03")
    public String handle03(){
        System.out.println("handle03");
        return "redirect:/hello.jsp";
    }

    @RequestMapping(value = "/handle04")
    public String handle04(){
        System.out.println("handle04");
        return "redirect:/handle03";
    }
}
