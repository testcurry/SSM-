package com.testcy.test;

import com.testcy.dao.BookDao;
import com.testcy.service.BookService;
import com.testcy.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:applicationContext01.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest {

//    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext01.xml");
    ApplicationContext ioc=null;

    @Autowired
    private BookDao bookDao;


    @Test
    public void testAutoWired(){
//        BookServlet bookServlet = (BookServlet) ioc.getBean("bookServlet");
//        bookServlet.doGet();
        bookDao.update();
    }
    @Test
    public void testAnnotation1(){
        Object bookDao = ioc.getBean("bookServlet");
        Object bookDao1 = ioc.getBean("bookServlet");
        System.out.println(bookDao1==bookDao);
    }

    @Test
    public void testAnnotation(){
        Object bookDao = ioc.getBean("bookDao1");
        Object bookDao1 = ioc.getBean("bookDao1");
        System.out.println(bookDao1==bookDao);
    }
}
