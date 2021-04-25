package com.testcy.test;

import com.testcy.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class TXTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() throws FileNotFoundException {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkOut("Tom","ISBN-001");
//        MulService mulBean = ioc.getBean(MulService.class);
//        mulBean.mulTx();
//        bookService.checkOut("Tom","ISBN-001");
//        System.out.println(bookService.getClass());
    }
}
