package com.testcy.service;

import org.springframework.stereotype.Service;

@Service
public class BookServiceExt extends BookService {

    @Override
    public void saveBook() {
        System.out.println("这是BookServiceExt重写的saveBook方法");
    }
}
