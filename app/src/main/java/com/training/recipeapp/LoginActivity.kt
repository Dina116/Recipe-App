package com.training.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.training.recipeapp.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Load the LoginFragment into the container
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.login_fragment_container, LoginFragment())
                .commit()
        }
    }
}
