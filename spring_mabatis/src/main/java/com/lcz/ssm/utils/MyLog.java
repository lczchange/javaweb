package com.lcz.ssm.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

public class MyLog {

    public void beforePrintLog() {
        System.out.println("前置通知");
    }

    public void afterReturnLog() {
        System.out.println("后置通知");
    }

    public void afterThrowingLog() {
        System.out.println("异常通知");
    }

    public void afterLog() {
        System.out.println("最终通知");
    }

    public void aroundLog(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            System.out.println("前置通知");
            proceedingJoinPoint.proceed();//相当于method.invoke()
            System.out.println("后置通知");
        } catch (Throwable e) {
            System.out.println("异常通知");
            e.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
    }
}
