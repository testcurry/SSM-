package com.testcy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 减余额
     *
     * @param userName
     * @param price
     */
    public void updateBalance(String userName, int price) {
        String sql = "UPDATE `account` SET `balance`=balance-? WHERE username =?";
//        int i= 10/0;
        jdbcTemplate.update(sql, price, userName);

    }

    /**
     * 根据图书编号获取图书价格
     * @param isbn
     * @return
     */
    public int getPrice(String isbn) {

        String sql = "SELECT `price` FROM book WHERE isbn=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;

    }

    public void updateStock(String isbn){
        String sql="UPDATE book_stock SET `stock`=`stock`-1 where isbn=?";
        jdbcTemplate.update(sql,isbn);

    }

    public void updatePrice(int newPrice,String isbn){
        String sql="UPDATE book SET price=? WHERE isbn=?";
        jdbcTemplate.update(sql,newPrice,isbn);
    }
}
