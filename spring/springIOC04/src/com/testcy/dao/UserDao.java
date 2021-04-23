package com.testcy.dao;

import com.testcy.bean.Book;
import com.testcy.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {


    @Override
    public void update() {
        System.out.println("UserDao的update()方法调用了！");
    }
}
