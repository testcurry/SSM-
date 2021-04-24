package com.testcy.impl;

import com.testcy.inter.Calculator;

public class MyMathCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        int ressult=i + j;
        return ressult;
    }

    @Override
    public int sub(int i, int j) {
        int ressult=i - j;
        return ressult;
    }

    @Override
    public int mul(int i, int j) {
        int ressult=i * j;
        return ressult;
    }

    @Override
    public int div(int i, int j) {
        int ressult=i / j;
        return ressult;
    }
}
