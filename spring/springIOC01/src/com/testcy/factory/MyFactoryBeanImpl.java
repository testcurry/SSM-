package com.testcy.factory;

import com.testcy.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

public class MyFactoryBeanImpl implements FactoryBean<Book> {

    /**
     * 返回创建的实例对象
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImpl正在创建book对象。。。");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    /**
     * 返回创建对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 是单例吗
     * @return false 不是单例
     */
    @Override
    public boolean isSingleton() {
//        return false;
        return true;
    }
}
