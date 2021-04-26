package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * helloworld细节：
 *  1、运行流程
 *      1、客户端点击链接会发送http://localhost:8080/springmvc01/hello请求
 *      2、来到Tomcat服务器
 *      3、springMVC的前端控制器DispatcherServlet收到所有请求
 *      4、DispatcherServlet来判断请求地址@RequestMapping标注的哪个地址匹配，来找到对应的方法处理
 *      5、DispatcherServlet找到目标处理器和目标方法，直接利用反射处理目标方法
 *      6、方法执行完成会获取返回值，springMVC会认为这个返回值就是要去的页面地址
 *      7、拿到方法返回值后用视图解析器拼接，获取完整的返回地址
 *      8、拿到页面地址，前端控制器帮我们转发到页面
 *  2、@RequestMapping：
 *      1、就是告诉springMVC这个方法用来处理哪个请求，这个 / 可以省略，省略了也是默认从当前项目路径
 *      2、注解的属性：
 *          1、method
 *
 *
 */
@Controller
public class MyFirstController {

    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("请求收到了，正在处理中。。。");
        return "success";
    }
    @RequestMapping("/hello1")
    public String mySencondRequest(){
        System.out.println("请求收到了，正在处理中。。。");
        return "error";
    }
    @RequestMapping("/hello2")
    public String myThirdRequest(){
        System.out.println("请求收到了，正在处理中。。。");
        return "success";
    }
}
