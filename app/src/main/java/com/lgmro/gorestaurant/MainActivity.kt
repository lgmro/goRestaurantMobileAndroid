package com.lgmro.gorestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lgmro.gorestaurant.presentation.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = LoginActivity.startLoginActivity(this)
        startActivity(intent)
    }
}