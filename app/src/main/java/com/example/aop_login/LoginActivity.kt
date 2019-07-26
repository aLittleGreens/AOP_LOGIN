package com.example.aop_login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aop_login.manager.UserManager

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        UserManager.setLogin(this, true)
    }
}
