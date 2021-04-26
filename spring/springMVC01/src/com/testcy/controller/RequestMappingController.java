package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hhh")
public class RequestMappingController {

    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("handle01请求处理中。。。");
        return "success";
    }

    /**
     *@RequestMapping的属性：
     * 1、value指定接口映射地址
     * 2、method = RequestMethod.GET指定请求方式
     * 3、params规定请求参数
     *      1、params = {"username"}请求参数必须包含username
     *      2、params = {"username"}请求参数必须不包含username
     *      3、params = {"username=123"}请求参数必须包含username,且值为123
     *      4、params = {"username=123"}请求参数必须包含username,且值不为123，不带值或不带参数都是不带
     *      5、params = {"username!=123","pwd","!age"}请求参数必须满足所有的规则
     *4、headers规定请求头：简单的表达式跟params一样，也可以写
     *      1、headers = {"User-Agent=xxxChrome“}只有Chrome浏览器才能访问
     *      2、headers = {"User-Agent!=xxxChrome“}Chrome浏览器不能访问
     *      3、。。。
     *
     * 5、  consumes;只接收内容类型是哪种的请求，由请求头中的Content-Type决定
     *
     * 6、  produces;告诉浏览器返回的内容类型是什么？给响应头中加Content-Type
     *
     *
     * @return String
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.GET)
    public String handle02(){
        System.out.println("handle01请求处理中。。。");
        return "success";
    }

    @RequestMapping(value = "/handle03",params = {"username!=123","pwd","!age"})
    public String handle03(){
        System.out.println("handle01请求处理中。。。");
        return "success";
    }

    //User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36
    @RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36"})
    public String handle04(){
        System.out.println("handle01请求处理中。。。");
        return "success";
    }
}
