package com.testcy.service;

import com.testcy.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void updatePrice(String isbn,int price){
        bookDao.updatePrice(price,isbn);
    }


    /**
     *事务细节：
     *  1、isolation-Isolation 事务的隔离级别
     *  2、propagation-Propagation 事务的传播行为
     *  3、RollbackFor-Class[] 哪些事务异常需要回滚
     *      异常的分类：
     *          默认编译时异常不回滚
     *          默认运行时异常回滚
     *  4、noRollbackForClassName-String[](全类名) 哪些事务异常不回滚
     *  5、noRollbackForClassName-Class[] (类型)
     *  6、readOnly-Boolean 设置事务为只读事务
     *  7、timeout-int  设置事务超时时间
     *
     *
     */

    @Transactional(propagation = Propagation.REQUIRED/*,rollbackFor = {IOException.class},noRollbackFor = {ArithmeticException.class},timeout = 3*/)
    public void checkOut(String name,String isbn) throws FileNotFoundException {

        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);
    /*    try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        bookDao.updateBalance(name,price);

        System.out.println("结账完成。。。");
//        new FileInputStream("d://aaaa.aa");
//        int i=10/0;
    }
}
