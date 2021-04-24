package com.testcy.impl;

public class MyMathCalculator /*implements Calculator*/ {
    //    @Override
    public int add(int i, int j) {
        int ressult = i + j;
        System.out.println("add方法执行了。。。");
        return ressult;
    }

    public double add(int i, double j) {
        double ressult = i + j;
        return ressult;
    }

    //    @Override
    public int sub(int i, int j) {
        int ressult = i - j;
        return ressult;
    }

    //    @Override
    public int mul(int i, int j) {
        int ressult = i * j;
        return ressult;
    }

    //    @Override
    public int div(int i, int j) {
        int ressult = i / j;
        return ressult;
    }
}
