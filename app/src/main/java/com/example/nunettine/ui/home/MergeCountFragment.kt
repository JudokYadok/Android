package com.example.nunettine.ui.home

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.QuizSolveView
import com.example.nunettine.databinding.FragmentMergeCountBinding
import com.example.nunettine.ui.main.MainActivity

class MergeCountFragment: Fragment() {
    private lateinit var binding: FragmentMergeCountBinding
    private lateinit var viewModel: HomeViewModel
    private var type = ""
    private var category = ""
    private var text_id = 0
    private var text_title = ""
    private var quiz_type = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMergeCountBinding.inflate(layoutInflater)
        getData()
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.mergeCountTv.text = text_title

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        mergeCountBackBtn.setOnClickListener { moveFragment(PreviewContentsFragment()) }

        mergeCountType1Btn.setOnClickListener { quiz_type = clickButton(mergeCountType1Btn) }
        mergeCountType2Btn.setOnClickListener { quiz_type = clickButton(mergeCountType2Btn) }
        mergeCountType3Btn.setOnClickListener { quiz_type = clickButton(mergeCountType3Btn) }
        mergeCountType4Btn.setOnClickListener { quiz_type = clickButton(mergeCountType4Btn) }
        mergeCountType5Btn.setOnClickListener { quiz_type = clickButton(mergeCountType5Btn) }

        mergeCountBtn.setOnClickListener {
            if(type == "PREVTEXT") {
                viewModel.setPrevQuizTypeService(category, text_id, quiz_type)
                moveFragment(ProblemFragment())
            } else {
//            setStudyMyDetailService(category, text_id)
            }
        }
    }

    private fun clickButton(clickedButton: Button): String = with(binding) {
        val buttons = listOf(
            mergeCountType1Btn,
            mergeCountType2Btn,
            mergeCountType3Btn,
            mergeCountType4Btn,
            mergeCountType5Btn
        )

        buttons.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
        mergeCountBtn.isEnabled = true
        return clickedButton.text.toString()
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

    private fun getData() {
        // 데이터 읽어오기
        val sharedPreferences1: SharedPreferences = requireContext().getSharedPreferences("text", MODE_PRIVATE)
        text_title = sharedPreferences1.getString("text_title", text_title)!!

        val sharedPreferences2: SharedPreferences = requireContext().getSharedPreferences("type", MODE_PRIVATE)
        type = sharedPreferences2.getString("type", type)!!
        category = sharedPreferences2.getString("category", category)!!
        text_id = sharedPreferences2.getInt("text_id", text_id)
    }
}