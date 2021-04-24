package com.testcy.utils;

import org.aspectj.lang.JoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class ValidateAspect {

    public static void logStart(JoinPoint joinPoint) {
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        System.out.println("ValidateAspect普通前置通知【 " + methodName + " 】方法执行开始了！。。。参数列表是：" + "【" + Arrays.asList(args) + "】");
    }

    /**
     * @param joinPoint
     * @param result
     */
    public static void logReturn(JoinPoint joinPoint, Object result) {

        System.out.println("ValidateAspect普通返回通知【" + joinPoint.getSignature().getName() + "】方法执行正常完成了！。。。计算结果是：" + "【" + result + "】");
    }

    /**
     * @param joinPoint
     * @param e
     */
    public static void logExecption(JoinPoint joinPoint, Exception e) {

        System.out.println("ValidateAspect普通异常通知方法【" + joinPoint.getSignature().getName() + "】执行异常了，异常信息是：" + "【" + e + "】");
    }

    private int logEnd(JoinPoint joinPoint) {

        System.out.println("ValidateAspect普通后置通知方法【" + joinPoint.getSignature().getName() + "】执行最终结束了！");
        return 0;
    }

    /**
     * @Around()环绕通知 环绕：就是动态代理
     * 将前置通知，返回通知，异常通知，后置通知  四合一就称为环绕通知
     *
     * 不加环绕通知时多切面同时切入一个方法执行正常的执行顺序：
     * {
             * 普通前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
             * ValidateAspect普通前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
             * add方法执行了。。。
             * ValidateAspect普通返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
             * ValidateAspect普通后置通知方法【add】执行最终结束了！
             * 普通返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
             * 普通后置通知方法【add】执行最终结束了！
     * }
     *
     * 不加环绕通知时多切面同时切入一个方法出现异常的顺序：
     * {
     *      *普通前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
     *      * ValidateAspect普通前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
     *      * ValidateAspect普通异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
     *      * ValidateAspect普通后置通知方法【div】执行最终结束了！
     *      * 普通异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
     *      * 普通后置通知方法【div】执行最终结束了！
     * }
     *
     * 加环绕通知时多切面同时切入一个方法执行正常的执行顺序：
     *  {
            ValidateAspect普通前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
            环绕前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
            普通前置通知【 add 】方法执行开始了！。。。参数列表是：【[1, 2]】
            add方法执行了。。。
            普通返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
            普通后置通知方法【add】执行最终结束了！
            环绕返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
            环绕后置通知方法【add】执行最终结束了！
            ValidateAspect普通返回通知【add】方法执行正常完成了！。。。计算结果是：【3】
            ValidateAspect普通后置通知方法【add】执行最终结束了！
     *
     *  }
     * 加环绕通知时多切面同时切入一个方法执行异常的执行顺序：
     * {
            ValidateAspect普通前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
            环绕前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
            普通前置通知【 div 】方法执行开始了！。。。参数列表是：【[1, 0]】
            普通异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
            普通后置通知方法【div】执行最终结束了！
            环绕异常通知方法【div】执行异常了，异常信息是：【java.lang.ArithmeticException: / by zero】
            环绕后置通知方法【div】执行最终结束了！
            ValidateAspect普通异常通知方法【div】执行异常了，异常信息是：【java.lang.RuntimeException: java.lang.ArithmeticException: / by zero】
            ValidateAspect普通后置通知方法【div】执行最终结束了！
     *
     * }
     */
}
