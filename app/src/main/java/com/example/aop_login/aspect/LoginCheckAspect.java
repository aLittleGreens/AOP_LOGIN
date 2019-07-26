package com.example.aop_login.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.example.aop_login.LoginActivity;
import com.example.aop_login.manager.UserManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Created by LittleGreens
 * @data on 2019/7/26
 * @describe 登录检测
 */

@Aspect // 定义切面类
public class LoginCheckAspect {

    private final static String TAG = "LoginCheckAspect";

    // 1、找到切入点
    // * *(..)) 可以处理LoginCheck这个类所有的方法
    @Pointcut("execution(@com.example.aop_login.annotation.LoginCheck * *(..))")
    public void methodPointCut() {
    }

    // 2、对切入点如何处理

    @Around("methodPointCut()")
    public Object jointPotin(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getThis();
        if (UserManager.INSTANCE.isLogin(context)) { //从SharedPreferences中读取
            //已登录
            Log.e(TAG, "检测到已登录！");
            return joinPoint.proceed();
        } else {
            //未登录，跳转登录
            Log.e(TAG, "检测到未登录！");
            Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return null; // 不再执行方法（切入点）
        }

    }

}
