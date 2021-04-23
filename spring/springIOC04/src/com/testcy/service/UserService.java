package com.testcy.service;

import com.testcy.bean.User;
import com.testcy.dao.BookDao;
import com.testcy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

  /*  @Autowired
    UserDao userDao;

    public void save(){
        userDao.update();
    }*/
}
