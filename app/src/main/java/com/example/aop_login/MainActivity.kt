package com.example.aop_login


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aop_login.annotation.ClickBehavior
import com.example.aop_login.annotation.LoginCheck
import com.example.aop_login.manager.UserManager


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = "MainActivity"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 登录点击事件（用户行为统计）
    @ClickBehavior("登录")
    fun login(view: View) {
        Log.e(TAG, "模拟接口请求……验证通过，登录成功！")
        startActivity(Intent(this, LoginActivity::class.java))
    }

    // 用户行为统计（友盟统计？！后台要求自己统计）
    @ClickBehavior("我的专区")
    @LoginCheck
    fun area(view: View) {
        Log.e(TAG, "开始跳转到 -> 我的专区 Activity")
        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("tag","我的专区")
        startActivity(intent)
    }

    // 用户行为统计
    @ClickBehavior("我的优惠券")
    @LoginCheck
    fun coupon(view: View) {
        Log.e(TAG, "开始跳转到 -> 我的优惠券 Activity")
        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("tag","我的优惠券")
        startActivity(intent)
    }

    // 用户行为统计
    @ClickBehavior("我的积分")
    @LoginCheck
    fun score(view: View) {
        Log.e(TAG, "开始跳转到 -> 我的积分 Activity")
        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("tag","我的积分")
        startActivity(intent)
    }


    fun exitLogin(view:View){
        Toast.makeText(this, "退出登录！", Toast.LENGTH_SHORT).show()
        UserManager.setLogin(this,false)
    }

}
