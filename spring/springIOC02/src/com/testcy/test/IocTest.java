package com.testcy.test;

import com.testcy.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class IocTest {

//    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext01.xml");
    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext03.xml");

    @Test
    public void test02() {
        Person bean = ioc.getBean(Person.class);
        System.out.println(" "+bean);
    }
    @Test
    public void test01() {
        Object car01 = ioc.getBean("car01");
        System.out.println(" "+car01);
//        ioc.close();
    }

}