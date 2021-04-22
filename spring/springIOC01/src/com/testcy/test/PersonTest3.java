package com.testcy.test;

import com.testcy.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest3 {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

    @Test
    public void test01() {
        Person peron01 = (Person) ioc.getBean("person01");
        Person peron02 = (Person) ioc.getBean("person01");
        Person peron03 = (Person) ioc.getBean("person02");
        Person peron04 = (Person) ioc.getBean("person02");
        System.out.println("单实例："+(peron01==peron02)+"多实例："+(peron03==peron04));
    }

}
