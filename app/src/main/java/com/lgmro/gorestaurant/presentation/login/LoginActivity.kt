package com.lgmro.gorestaurant.presentation.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lgmro.gorestaurant.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    companion object {
        fun startLoginActivity(context: Context) = Intent(context, LoginActivity::class.java)
    }
}