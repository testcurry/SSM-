package com.testcy.service;

import com.testcy.bean.Book;
import com.testcy.dao.BaseDao;
import com.testcy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book>{

  /*  @Autowired
    BookDao bookDao;

    public void save(){
        bookDao.update();
    }*/
}
