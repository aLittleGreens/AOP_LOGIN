package com.example.aop_login.aspect;

import android.util.Log;
import com.example.aop_login.annotation.ClickBehavior;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author Created by LittleGreens
 * @data on 2019/7/25
 * @describe 定义切面图
 */
@Aspect
public class ClickBehaviorAspect {
    private final static String TAG = "ClickBehaviorAspect";

    //    1、应用中用到了哪些注解，放到当前的切入点进行处理（找到需要处理的切入点）
    //execution，以方法执行作为切入点，触发Aspect类
// * *(..)) 可以处理ClickBehavior这个类所有的方法
    @Pointcut("execution(@com.example.aop_login.annotation.ClickBehavior * *(..))")
    public void methodPointCut() {//方法名随意写

    }

    //    2、对切入点如何处理
    @Around("methodPointCut()")
    public Object jointPotin(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取签名方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //获取方法所属类名
        String className = methodSignature.getDeclaringType().getName();

        //获取方法名
        String methodName = methodSignature.getName();

        //获取方法的注解值（用于统计行为）
        String funName = methodSignature.getMethod().getAnnotation(ClickBehavior.class).value();

        //eg：统计方法执行时间，统计用户点击某功能（存储到本地，没过x天，上传后台）
        long begin = System.currentTimeMillis();
        Log.e(TAG, "ClickBehavior Method Start >>> ");
        Object result = joinPoint.proceed(); // 执行MainActivity中切面的方法
        long duration = System.currentTimeMillis() - begin;
        Log.e(TAG, "ClickBehavior Method End >>> ");
        Log.e(TAG, String.format("统计了：%s功能，在%s类的%s方法，用时%d ms",
                funName, className, methodName, duration));

        return result;
    }


}
