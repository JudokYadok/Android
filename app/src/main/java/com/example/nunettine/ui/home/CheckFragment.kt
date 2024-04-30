package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentCheckBinding
import com.example.nunettine.ui.main.MainActivity

class CheckFragment: Fragment() {
    private lateinit var binding: FragmentCheckBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCheckBinding.inflate(layoutInflater)

        clickListener()
        return binding.root
    }

    // 채점 API (get) -> omr setting 필요
    // 지문 요약 API (get)

    private fun clickListener() = with(binding) {
        problemSaveBtn.setOnClickListener {
            Toast.makeText(context, "응시 결과가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            moveFragment(HomeFragment())
            // 저장 API (post)
        }

        problemFeedbackBtn.setOnClickListener { moveFragment(ProblemFeedbackFragment()) }

        problemMemoBtn.setOnClickListener { moveFragment(MemoFragment()) }
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