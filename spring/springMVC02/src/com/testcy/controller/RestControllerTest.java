package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestControllerTest {

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer bid){
        System.out.println("查询图书，编号："+bid);
        return "success";
    }

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.POST)
    public String addBook(@PathVariable("bid") Integer bid){
        System.out.println("新增图书,编号："+bid);
        return "success";
    }

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer bid){
        System.out.println("修改图书，编号："+bid);
        return "success";
    }

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer bid){
        System.out.println("删除图书，编号："+bid);
        return "success";
    }
}
