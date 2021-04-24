package com.testcy.test;

import com.testcy.impl.MyMathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMathCalculatorTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testAop2() {
        MyMathCalculator myMathCalculator = (MyMathCalculator) ioc.getBean("myMathCalculator");
        myMathCalculator.add(1, 2);
//        int result = myMathCalculator.add(1, 2);
        myMathCalculator.div(1, 0);
//        System.out.println("------"+result);
//        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
//        System.out.println(bean.getClass());
    }

}