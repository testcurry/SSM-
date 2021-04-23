package com.testcy.servlet;

import com.testcy.dao.BookDao;
import com.testcy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resources;

@Controller
public class BookServlet {

    //找不到就装配null
    @Autowired(required = false)
    //可以使用这个让spring不使用变量名作为id去匹配，使用指定的id去匹配
    @Qualifier("bookService")
//    @Resources
    private BookService bookServiceExt;

    public void doGet(){
        System.out.println("bookServlet正在调用bookService帮您保存图书。。。"+bookServiceExt);
        bookServiceExt.saveBook();
    }

    //方法上写注解，方法参数的值会自动装配，这个方法会在bean创建的时候自动运行
    @Autowired(required = false)
    public void testHHH(BookDao bookDao,@Qualifier("bookServiceExt") BookService bookService){
        System.out.println("spring给testHHH方法参数自动装配了并执行。。。方法参数为bookDao"+bookDao+"bookService参数的值为："+bookService);
    }
}
