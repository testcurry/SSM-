package com.testcy.test;

import com.testcy.impl.MyMathCalculator;
import com.testcy.inter.Calculator;
import com.testcy.proxy.CalculatorProxy;
import org.junit.Test;

public class MyMathCalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new MyMathCalculator();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(1,2);
        proxy.div(2,0);
    }
}