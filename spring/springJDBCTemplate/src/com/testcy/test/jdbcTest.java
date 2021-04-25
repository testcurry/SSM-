package com.testcy.test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbcTest {
    /*
        实验1：测试数据源
        实验2：将emp_id=5的记录的salary字段更新为1300.00
        实验3：批量插入
        实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
        实验5：查询salary>4000的数据库记录，封装为List集合返回
        实验6：查询最大salary
        实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
        实验8：重复实验7，以SqlParameterSource形式传入参数值
        实验9：创建BookDao，自动装配JdbcTemplate对象
    * */
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

    //实验2：将emp_id=5的记录的salary字段更新为1300.00
    @Test
    public void test02() {
        String sql = "update employee set `salary`=? WHERE emp_id =?";
        jdbcTemplate.update(sql, 1300, 5);
    }


    //实验1：测试数据源
    @Test
    public void test() throws SQLException {
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test01() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(ioc.getBean(DataSource.class));
        System.out.println(jdbcTemplate);
    }

}
