package com.example.aop_login.annotation

import java.lang.annotation.RetentionPolicy
import kotlin.annotation.Retention

/**
 * @author Created by LittleGreens
 * @data on 2019/7/25
 * @describe 用户行为统计
 */

@Target(AnnotationTarget.FUNCTION)//目标作用在方法之上
@Retention(AnnotationRetention.RUNTIME)
annotation class ClickBehavior(val value: String)
