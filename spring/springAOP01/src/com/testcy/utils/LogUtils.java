package com.testcy.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {

    public static void logStart(Method method,Object...args){

        System.out.println("【" + method.getName() + "】方法执行开始了！。。。参数列表是：" + "【" + Arrays.asList(args) + "】");
    }
    public static void logReturn(Method method,Object result){

        System.out.println("【" + method.getName() + "】方法执行正常完成了！。。。计算结果是：" + "【"+result+"】");
    }
    public static void logExecption(Method method,Exception e){

        System.out.println("方法【" + method.getName() + "】执行异常了，异常信息是：" + "【"+e.getCause()+"】");
    }

    public static void logFinal(Method method){

        System.out.println("方法【" + method.getName() + "】执行最终结束了！");
    }
}
