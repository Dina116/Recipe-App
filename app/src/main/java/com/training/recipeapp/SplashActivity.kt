package com.training.recipeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // استخدام Handler للتأخير قبل الانتقال إلى MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // الانتقال إلى MainActivity بعد 4 ثواني
            startActivity(Intent(this, MainActivity::class.java))
            finish() // إنهاء SplashActivity لكي لا يتم الرجوع إليها
        }, 4000) // التأخير بالمللي ثانية (4 ثواني)
    }

}
