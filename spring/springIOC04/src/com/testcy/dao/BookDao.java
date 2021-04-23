package com.testcy.dao;

import com.testcy.bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void update() {
        System.out.println("BookDao的update()方法调用了！");
    }
}
