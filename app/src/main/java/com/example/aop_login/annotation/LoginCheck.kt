package com.example.aop_login.annotation

/**
 * @data on 2019/7/26
 * @author Created by LittleGreens
 * @describe 用户登录检测
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class LoginCheck{


}