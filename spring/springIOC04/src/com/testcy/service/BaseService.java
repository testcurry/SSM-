package com.testcy.service;

import com.testcy.bean.Book;
import com.testcy.dao.BaseDao;
import com.testcy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    public void save() {
        System.out.println("自动注入的baseD奥"+baseDao);
        baseDao.update();
    }
}
