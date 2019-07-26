package com.example.aop_login.manager

import android.content.Context

/**
 * @data on 2019/7/26
 * @author Created by LittleGreens
 * @describe 登录管理
 */

object UserManager {

    const val LOGIN_TAG = "login_tag"
    val spName = "setting"
    private val mode = Context.MODE_PRIVATE

    /**
     * 获取是否登录
     */
    fun isLogin(context: Context) = getBoolean(context, LOGIN_TAG, false)

    /**
     * 设备是否登录
     */
    fun setLogin(context: Context,isLogin:Boolean){
        putSpBoolean(context,LOGIN_TAG,isLogin)
    }


    private fun putSpBoolean(context: Context, key: String, value: Boolean) {
        val sp = context.getSharedPreferences(spName, mode)
        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.commit()
    }

    /**获取 */
   private fun getBoolean(context: Context, key: String, defValue: Boolean): Boolean {
        val sp = context.getSharedPreferences(spName, mode)
        return sp.getBoolean(key, defValue)
    }


}