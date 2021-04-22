package com.testcy.test;

import com.testcy.bean.AirPlane;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirPlaneFactoryTest {

    private ApplicationContext ioc =new ClassPathXmlApplicationContext("ioc3.xml");

    @Test
    public void testFactory03(){
        Object myFactoryBean01 = ioc.getBean("myFactoryBean");
        Object myFactoryBean02 = ioc.getBean("myFactoryBean");
        System.out.println(myFactoryBean01==myFactoryBean02);

    }

    @Test
    public void testFactory02(){
        AirPlane airPlane02 = (AirPlane) ioc.getBean("airPlane02");
        System.out.println(airPlane02);
    }

    @Test
    public void testFactory01(){
        AirPlane airPlane01 = (AirPlane) ioc.getBean("airPlane01");
        System.out.println(airPlane01);
    }


}
