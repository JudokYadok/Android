package com.example.nunettine.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.nunettine.R
import com.example.nunettine.databinding.ActivitySplashBinding

class SplashActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.gradient_expand_animation)
        binding.splashTv.startAnimation(animation)
        binding.splashIco.startAnimation(animation)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}