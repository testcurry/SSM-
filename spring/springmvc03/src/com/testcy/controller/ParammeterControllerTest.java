package com.testcy.controller;

import com.testcy.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


@Controller
public class ParammeterControllerTest {

    /**
     * 默认获取请求参数的值：
     * 给方法参数传入一个和请求参数一样的值，这个变量就来接收请求参数的值
     * 带参数。获取的请求参数username：tomcat
     * 不带参数。获取的请求参数username：null
     * @param username
     * @return
     */
    @RequestMapping(value = "/handle01")
    public String handle01(String username){
        System.out.println("获取的请求参数username："+username);
        return "success";
    }

    /**
     * 但是标了此注解，参数默认是必须带的，不带就报错
     * 但是可以修改此参数是否是必传参数
     * value:表示请求参数的key
     * required:表示该参数是否为必填
     * defaultValue:表示参数的默认值
     *
     * @RequestHeader 获取请求头中的信息
     * 没有携带这个请求头中就会报错，但是可以指定非必填和默认值 value = "ff-agent",required = false,defaultValue = "hhh"
     * @param username
     * @param useragent
     * @return
     */
    @RequestMapping(value = "/handle02")
    public String handle02(@RequestParam(value = "user",required = false,defaultValue = "admin") String username,
                           @RequestHeader(value = "ff-agent",required = false,defaultValue = "hhh") String useragent){
        System.out.println("获取的请求参数username："+username);
        System.out.println("获取的请求参数username："+useragent);
        return "success";
    }

    /**
     * value = "JSESSIONID",required = false,defaultValue = "asdfgsdgsd"
     * @param username
     * @param useragent
     * @param cookieValue
     * @return
     */
    @RequestMapping(value = "/handle03")
    public String handle03(@RequestParam(value = "user",required = false,defaultValue = "admin") String username,
                           @RequestHeader(value = "ff-agent",required = false,defaultValue = "hhh") String useragent,
                           @CookieValue(value = "JSESSIONID",required = false,defaultValue = "asdfgsdgsd") String cookieValue){
        System.out.println("获取的请求参数username："+username);
        System.out.println("获取的请求参数header中User-Agent："+useragent);
        System.out.println("获取的请求参数cookie中JSESSIONID的值："+cookieValue);
        return "success";
    }

    /**
     * 这种比较麻烦，可以直接写一个javabean作为请求参数
     * @param name
     * @param author
     * @param price
     * @param stock
     * @param sales
     * @return
     */
    @RequestMapping(value = "/book01",method = RequestMethod.POST)
    public String addBook(@RequestParam(value = "bookName") String name, @RequestParam(value = "author") String author, @RequestParam(value = "price") Integer price, @RequestParam(value = "stock") Integer stock, @RequestParam(value = "sales") Integer sales){
        System.out.println("获取的请求参数username："+name);
        System.out.println("获取的请求参数author："+author);
        System.out.println("获取的请求参数price的值："+price);
        System.out.println("获取的请求参数stock的值："+stock);
        System.out.println("获取的请求参数sales的值："+sales);
        return "success";
    }

    /**
     *直接传对象，springmvc会把对象中所有的属性从请求参数中获取，找到了就赋值
     *
     * 提交的数据可能存在乱码：
     * 请求乱码：
     *   get请求：修改Tomcat的配置，server.xml 在8080断口处增加URIEncoding=UTF-8;
     *   post请求：在第一次获取参数之前设置request.setCharacterEncoding("UTF-8");
     *   可以自己写一个Filter设置：但是springmvc帮我们写好了去web.xml中配置
     * 响应乱码：
     * response.setContentType("text/html; charset=UTF-8");
     * @return
     */
    @RequestMapping(value = "/book02",method = RequestMethod.POST)
    public String addBook(Book book) {
        System.out.println("我要保存的图书："+book);
        return "success";
    }

    /**
     * springmvc支持原生的API
     * HttpServletRequest
     * HttpSession
     * HttpServletResponse
     * java.security.princial
     * Locale:国际化的区域信息
     * InputStream:ServletInputStream inputStream = request.getInputStream();
     * OutPutStream:ServletOutputStream outputStream = response.getOutputStream();
     * Reader:BufferedReader reader = request.getReader();
     * Writer:BufferedReader reader = request.getReader();
     * @return
     */
    @RequestMapping(value = "/handle04")
    public String handle03(HttpSession session, HttpServletRequest request){
        session.setAttribute("sessionParam","我是session域中的数据。");
        request.setAttribute("requestParam","我是request域中的数据。");
        return "success";
    }

}
