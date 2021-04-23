package com.testcy.service;

import com.testcy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void saveBook() {
        System.out.println("bookService正在调用bookDao帮您保存图书！");
        bookDao.update();
    }
}
