package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentSettingFeedbackBinding
import com.example.nunettine.ui.main.MainActivity

class ProblemFeedbackFragment: Fragment() {
    private lateinit var binding: FragmentSettingFeedbackBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingFeedbackBinding.inflate(layoutInflater)
        binding.feedbackTv.setText("2022년 6월 평가원") // 지문 이름 불러오기 API -> spf로 대체하기!

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        feedbackBackBtn.setOnClickListener { moveFragment(CheckFragment()) }
        feedbackWriteYesBtn.setOnClickListener {
            Toast.makeText(context, "피드백이 전달되었습니다.", Toast.LENGTH_SHORT).show()
            moveFragment(CheckFragment())
        }
        feedbackWriteNoBtn.setOnClickListener { moveFragment(CheckFragment()) }
    }

    private fun moveFragment(fragment: Fragment) {
        val mainActivity = context as MainActivity
        val mainFrmLayout = mainActivity.findViewById<FrameLayout>(R.id.main_frm) as FrameLayout?
        if (mainFrmLayout != null) {
            val transaction = mainActivity.supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            transaction.replace(mainFrmLayout.id, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}