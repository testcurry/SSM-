package com.testcy.test;

import com.testcy.dao.BookDao;
import com.testcy.dao.UserDao;
import com.testcy.service.BookService;
import com.testcy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext01.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testGeneric {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Test
    public void testT() {
        bookService.save();
        userService.save();
        //bookService的带泛型的父类：com.testcy.service.BaseService<com.testcy.bean.Book>
        System.out.println("bookService的带泛型的父类："+bookService.getClass().getGenericSuperclass());
    }


}
