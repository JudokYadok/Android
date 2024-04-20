package com.example.nunettine.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentSettingMypageBinding
import com.example.nunettine.ui.home.HomeFragment

class MypageFragment: Fragment() {
    private lateinit var binding: FragmentSettingMypageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingMypageBinding.inflate(layoutInflater)
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        mypageBackBtn.setOnClickListener { moveFragment(SettingFragment()) }
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}