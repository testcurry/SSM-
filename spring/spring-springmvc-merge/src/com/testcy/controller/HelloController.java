package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
//    @ResponseStatus(reason = "反正我错了。。。",value = HttpStatus.NOT_EXTENDED)
    public String handle01() {
        System.out.println("hello");
        return "success";
    }
}
