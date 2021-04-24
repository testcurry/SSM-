package com.testcy.proxy;

import com.testcy.inter.Calculator;
import com.testcy.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
* 动态代理的缺点：
* 1、实现起来比较复杂
* 2、jdk的动态代理，如果目标对象的类没有实现任何接口，则无法为其创建动态代理
*
* */
public class CalculatorProxy {

    /**
     * 为传入的参数对象创建一个动态代理对象
     *
     * @param calculator
     * @return Calculator 返回被代理对象
     * 传入Calculator calculator被代理对象
     */
    public static Calculator getProxy(final Calculator calculator) {
        //方法执行器，帮我们目标对象执行目标方法
        InvocationHandler h = new InvocationHandler() {
            /*
             Object proxy,代理对象，给jdk使用，我们任何时候都不要动这个对象
             Method method,当前将要执行的目标对象的方法,参数args就是目标对象的方法参数，obj就是目标对象
             Object[] args
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标对象的方法
//                System.out.println("这是动态代理帮你执行的方法！");
                Object result = null;
                try {
                    LogUtils.logStart(method,args);
                    result = method.invoke(calculator, args);
                   LogUtils.logReturn(method,result);
                } catch (Exception e) {
                   LogUtils.logExecption(method,e);
                } finally {
                   LogUtils.logFinal(method);
                }
                return result;
            }
        };
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Calculator) proxy;
    }
}
