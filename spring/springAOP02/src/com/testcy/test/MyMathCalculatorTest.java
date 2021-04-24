package com.testcy.test;

import com.testcy.impl.MyMathCalculator;
import com.testcy.inter.Calculator;
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

    @Test
    public void testAop1() {
        Calculator bean = (Calculator) ioc.getBean(Calculator.class);
        bean.add(1, 2);
        //com.testcy.impl.MyMathCalculator@4a668b6e
        System.out.println(bean);
        //class com.sun.proxy.$Proxy18
        System.out.println(bean.getClass());
        Calculator myMathCalculator = (Calculator) ioc.getBean("myMathCalculator");
        System.out.println(myMathCalculator.getClass());
//        bean.mul(1, 0);
//        bean.sub(1, 0);
//        bean.div(1, 0);

    }
}