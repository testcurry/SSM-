package com.testcy.dao.impl;

import com.testcy.utils.JDBCUtils;
import com.testcy.utils.WebUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//org.apache.commons.dbutils.QueryRunner

import java.sql.Connection;
import java.util.List;

public abstract class BaseDao {

//    private QueryRunner queryRunner = new QueryRunner();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * update()用来执行update/insert/delete语句
     *
     * @return -1为未查到
     */
    public int update(String sql, Object... args) {
        System.out.println("BaseDao当前线程名：" + Thread.currentThread().getName());
        int updateCount = jdbcTemplate.update(sql, args);
        return updateCount;
    }

    /**
     * 查询返回一条JavaBean的方法
     *
     * @param type 需要查询的类型
     * @param sql  sql语句
     * @param args sql语句的占位符
     * @param <T>  返回的JavaBean的类型的泛型
     * @return
     * @throws Exception
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        T t = null;
        try {
            t = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), args);
        } catch (DataAccessException e) {
        }
        return t;
    }

    /**
     * 查询返回多条JavaBean的方法
     *
     * @param type 需要查询的类型
     * @param sql  sql语句
     * @param args sql语句的占位符
     * @param <T>  返回的JavaBean的类型的泛型
     * @return
     * @throws Exception
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), args);
    }

    /**
     * 查询返回一个单行单列值得方法
     *
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Object value = jdbcTemplate.queryForObject(sql, Object.class, args);
        return value;
    }

}
