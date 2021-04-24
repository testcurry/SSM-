package com.testcy.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class LogUtils {

    /*
     * 告诉spring每个方法都是什么时候运行
     * 切入点表达式 支持通配符*，但我们尽量要写详细  ，权限修饰符不支持。默认不写就是public execution(public int com.testcy.impl.MyMathCalculator.*(int,int)
     * 获取要执行的方法名 用JoinPoint joinPoint对象获取org.aspectj.lang.JoinPoint
     * */
    public static void logStart(JoinPoint joinPoint) {
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("LogUtils普通前置通知【 " + methodName + " 】方法执行开始了！。。。参数列表是：" + "【" + Arrays.asList(args) + "】");
    }

    /**
     * Object result返回结果类型要写Object可以接受所有的类型的返回值，如果指定某种类型，则只能接收某种指定的类型的返回值
     *
     * @param joinPoint
     * @param result
     */
    public static void logReturn(JoinPoint joinPoint, Object result) {

        System.out.println("LogUtils普通返回通知【" + joinPoint.getSignature().getName() + "】方法执行正常完成了！。。。计算结果是：" + "【" + result + "】");
    }

    /**
     * 异常要写最大的异常，这样才能将所有的异常都捕获到
     * Exception e，
     * 如果是其他异常，则只会捕获指定类型的异常和其异常的子异常
     *
     * @param joinPoint
     * @param e
     */
    public static void logExecption(JoinPoint joinPoint, Exception e) {

        System.out.println("LogUtils普通异常通知方法【" + joinPoint.getSignature().getName() + "】执行异常了，异常信息是：" + "【" + e + "】");
    }

    /**
     * 1、spring对通知方法定义要求不高，权限和有没有返回值都没有要求，
     * 2、但是方法参数必须要绑定，确保spring调用时无异常
     */
    private int logEnd(JoinPoint joinPoint) {

        System.out.println("LogUtils普通后置通知方法【" + joinPoint.getSignature().getName() + "】执行最终结束了！");
        return 0;
    }

    /**
     * @Around()环绕通知 环绕：就是动态代理
     * 将前置通知，返回通知，异常通知，后置通知  四合一就称为环绕通知
     *
     * 环绕通知和普通通知同时执行后的执行顺序：
     * {
     * 1、环绕前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
     * 2、普通前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
     * 3、普通返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
     * 4、普通后置通知方法【add】执行最终结束了！
     * 5、环绕返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
     * 6、环绕后置通知方法【add】执行最终结束了！
     * }
     *
     * 出现异常的顺序：
     * {
     *  1、环绕前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
     * 2、普通前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
     * 3、普通异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
     * 4、普通后置通知方法【div】执行最终结束了！
     * 5、环绕异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
     * 6、环绕后置通知方法【div】执行最终结束了！
     * }
     */
    public Object MyAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();
        //利用反射推进方法的运行
        Object proceed = null;
        try {
            //前置通知
            System.out.println("环绕前置通知【 " + name + " 】方法执行开始了！。。。参数列表是：" + "【" + Arrays.asList(args) + "】");
            proceed = pjp.proceed(args);//与method.invoke()作用相同
            //返回通知
            System.out.println("环绕返回通知【" + name + "】方法执行正常完成了！。。。计算结果是：" + "【" + proceed + "】");
        } catch (Exception e) {
            //异常通知
            System.out.println("环绕异常通知方法【" + name + "】执行异常了，异常信息是：" + "【" + e + "】");
            throw new RuntimeException(e);
        } finally {
            //后置通知
            System.out.println("环绕后置通知方法【" + name + "】执行最终结束了！");
        }
//        System.out.println("环绕通知哈哈哈哈或...");
        return proceed;
    }

}
