package com.example.nunettine.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nunettine.R
import com.example.nunettine.databinding.ActivityMainBinding
import com.example.nunettine.ui.home.HomeFragment
import com.example.nunettine.ui.home.HomeIntroFragment
import com.example.nunettine.ui.save.SaveFragment
import com.example.nunettine.ui.setting.SettingFragment

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        binding.mainNavi.selectedItemId = R.id.navi_home
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeIntroFragment())
            .commitAllowingStateLoss()

        binding.mainNavi.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.navi_home -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.navi_save -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.main_frm, SaveFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.navi_setting -> {
                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                        .replace(R.id.main_frm, SettingFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}