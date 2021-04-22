package com.testcy.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestSqlConnection {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext02.xml");
    @Test
    public void test01() throws SQLException {
//        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        DataSource datasource = ioc.getBean(DataSource.class);
        System.out.println(datasource.getConnection());
    }


    @Test
    public void test02() {
        Object car01 = ioc.getBean("car01");
        System.out.println(" "+car01);
//        ioc.close();
    }

}
