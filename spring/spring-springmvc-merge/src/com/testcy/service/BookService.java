package com.testcy.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BookService() {
        System.out.println("BookService创建。。。");
    }

    public String updateBook(){
        return "图书更新成功。。。";
    }
}
