package com.testcy.controller;

import com.testcy.bean.Employee;
import com.testcy.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;

@Controller
public class AjaxControllerTest {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     *文件下载
     * ResponseEntity<Byte>响应体中内容类型为Byte
     * @return
     */
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        String location = request.getServletContext().getRealPath("/script/jquery-3.5.1.min.js");
//        String location="path"+"/script/jquery-3.5.1.min.js";
        FileInputStream is = new FileInputStream(location);
        FileOutputStream fs = new FileOutputStream("E:/tmp/jquery.js");
        byte[] buffer=new byte[1024];
        int length;
        int byteSum=0;
        while ((length=is.read(buffer))!=-1){
            byteSum+=length;
            fs.write(buffer,0,length);
        }
        is.close();
        fs.close();
        byte[] bytes=new byte[byteSum];
        MultiValueMap<String, String> hearders = new HttpHeaders();
        hearders.add("Content-Disposition","attachment;filename="+"jquery.js");

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, hearders, HttpStatus.OK);
        return responseEntity;
    }

    /**
     * ResponseEntity<String>响应体中内容类型为string
     * @return
     */
    @RequestMapping("/test04")
    @ResponseBody
    public ResponseEntity<String> test04(){
        String body="<h1>success</h1>";
        MultiValueMap<String,String> headers=new HttpHeaders();
        headers.add("Set-Cookie","username=Curry");
        HttpStatus status=HttpStatus.OK;
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(body,headers,status);
        return responseEntity;
    }


    /**
     * 本质含义就是将返回值放进HTML的body中然后直接返回
     * @return
     */
    @RequestMapping("/test03")
    @ResponseBody
    public String test03(){
        return "<h1>success</h1>";
    }

    @RequestMapping("/test02")
    public String test01(HttpEntity<String>  body){
        System.out.println("请求体的内容是："+body);
        return "success";
    }

    @RequestMapping("/test01")
    public String test01(@RequestBody String body){
        System.out.println("请求体的内容是："+body);
        return "success";
    }


  /*  @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody(required = true) String body){
        System.out.println(body);
        return "success";
    }*/

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody(required = true) Employee employee){
        System.out.println(employee);
        return "success";
    }


    @RequestMapping(value = "/getallajax",method = RequestMethod.GET)
    @ResponseBody
    public Collection<Employee> test(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
}
