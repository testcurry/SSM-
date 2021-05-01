package com.testcy.controller;

import com.testcy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {


    private BookService bookService;
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookController() {
        System.out.println("bookController创建。。。");
    }

    @RequestMapping("/book")
    public String hello(){
        System.out.println(bookService);
        String book = bookService.updateBook();
        System.out.println(book);
        return "success";
    }
}
