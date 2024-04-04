package com.example.nunettine.ui.home

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentHomeIntroBinding

class HomeIntroFragment: Fragment() {
    private lateinit var binding: FragmentHomeIntroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeIntroBinding.inflate(layoutInflater)
        clickListener()
        Handler().postDelayed({
            moveFragment(HomeFragment())
        }, 2000)

        return binding.root
    }

    private fun clickListener() = with(binding) {
    }
    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}