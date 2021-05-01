package com.testcy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionControllerTest {

    @RequestMapping("/handle01")
//    @ResponseStatus(reason = "反正我错了。。。",value = HttpStatus.NOT_EXTENDED)
    public String handle01(Integer i) {
        System.out.println("handle01");
        System.out.println(10 / i);
        return "success";
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String username) {
        if (!"admin".equals(username)) {
            System.out.println("登录失败！");
            throw new UserNotFoundException();
        }
        System.out.println("登录成功!");
        return "success";
    }

    @RequestMapping(value = "/handle03", method = RequestMethod.POST)
    public String handle03() {

        return "success";
    }

    @RequestMapping(value = "/handle04", method = RequestMethod.GET)
    public String handle04() {
        System.out.println("handle04...");
        String str = null;
        System.out.println(str.charAt(0));
        return "success";
    }

    /**
     * 告诉springmvc这个方法专门处理这个类发生的异常
     * 注意：方法参数上只能写Exception类型的参数，不接收其他的参数类型，不能写类似Model类型的参数，
     * 直接返回一个ModelAndView即可
     * 有多个处理异常的方法，精确优先
     * 存在全局集中处理异常的类，本类处理异常的方法优先，无论精确不精确
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException01(Exception e) {
        System.out.println("局部的handleException01..." + e);
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg", e);
        return view;
    }
}
