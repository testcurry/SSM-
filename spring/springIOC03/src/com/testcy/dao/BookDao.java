package com.testcy.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//@Repository("bookDao1")
//@Scope("prototype")
@Repository
public class BookDao {
    /*
    * @Repository("bookDao1") 组件默认id为类名首字母小写，可以给id重新命名
      @Scope("prototype")       给组件设置多实例
    * */
    public void update() {
        System.out.println("插入一条图书记录！");
    }
}
