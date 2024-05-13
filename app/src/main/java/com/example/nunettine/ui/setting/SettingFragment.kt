package com.example.nunettine.ui.setting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentSettingBinding
import com.example.nunettine.ui.main.LoginActivity
import com.kakao.sdk.user.UserApiClient

class SettingFragment: Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        settingMypageLo.setOnClickListener { moveFragment(MypageFragment()) }
        settingInfoLo.setOnClickListener { moveFragment(InfoFragment()) }
        settingFeedbackLo.setOnClickListener { moveFragment(FeedbackFragment()) }
        settingLogoutLo.setOnClickListener { logout() }
    }

    private fun logout() {
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e("KAKAO-LOGOUT-실패", "로그아웃 실패. SDK에서 토큰 삭제됨", error)
            } else {
                Log.i("KAKAO-LOGOUT-성공", "로그아웃 성공. SDK에서 토큰 삭제됨")
                Toast.makeText(context, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                navigateToFirstScreen()
            }
        }
    }

    private fun navigateToFirstScreen() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .addToBackStack(null)
            .commit()
    }
}