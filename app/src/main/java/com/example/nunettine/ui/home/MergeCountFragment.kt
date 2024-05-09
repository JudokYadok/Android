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
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.QuizSolveView
import com.example.nunettine.databinding.FragmentMergeCountBinding
import com.example.nunettine.ui.main.MainActivity

class MergeCountFragment: Fragment(), QuizSolveView {
    private lateinit var binding: FragmentMergeCountBinding
    private var type = arguments?.getInt("type")
    private var category = arguments?.getString("category")
    private var text_id = arguments?.getInt("text_id")
    private var text_title = ""
    private var quiz_type = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMergeCountBinding.inflate(layoutInflater)
        getData()
        binding.mergeCountTv.text = text_title
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        mergeCountBackBtn.setOnClickListener { moveToDetailFragment(type!!, text_id!!, category!!) }

        mergeCountType1Btn.setOnClickListener { quiz_type = clickButton(mergeCountType1Btn) }
        mergeCountType2Btn.setOnClickListener { quiz_type = clickButton(mergeCountType2Btn) }
        mergeCountType3Btn.setOnClickListener { quiz_type = clickButton(mergeCountType3Btn) }
        mergeCountType4Btn.setOnClickListener { quiz_type = clickButton(mergeCountType4Btn) }
        mergeCountType5Btn.setOnClickListener { quiz_type = clickButton(mergeCountType5Btn) }

        mergeCountBtn.setOnClickListener {setPrevQuizTypeService(category!!, text_id!!, quiz_type) }
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

    private fun moveToDetailFragment(type: Int, text_id: Int, category: String) {
        val previewContentsFragment = PreviewContentsFragment.newInstance(type, text_id, category)
        moveFragment(previewContentsFragment)
    }

    private fun moveToQuizFragment(type: Int, text_id: Int, category: String, quiz_type: String, quiz_list: ArrayList<String>, quiz_answer: ArrayList<Int>) {
        val problemFragment = ProblemFragment.newInstance(type, text_id, category, quiz_type, quiz_list, quiz_answer)
        moveFragment(problemFragment)
    }

    private fun getData() {
        // 데이터 읽어오기
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("text", MODE_PRIVATE)
        text_title = sharedPreferences.getString("text_title", text_title)!!
    }

    private fun setPrevQuizTypeService(category: String, text_id: Int, quiz_type: String) {
        val setPrevQuizTypeService = QuizService()
        setPrevQuizTypeService.setQuizSolveView(this@MergeCountFragment)
        setPrevQuizTypeService.setPrevQuizSolve(category, text_id, quiz_type)
    }

    override fun onGetQuizSolveSuccess(response: QuizSolveRes) {
        moveToQuizFragment(type!!, text_id!!, category!!, quiz_type, response.quiz_list, response.quiz_answer)
        Log.d("QUIZ-MAKE-성공", response.toString())
    }

    override fun onGetQuizSolveFailure(result_code: Int, result_req: String) {
        Log.d("QUIZ-MAKE-오류", result_req)
    }

    companion object {
        fun newInstance(type: Int, text_id: Int, category: String): MergeCountFragment {
            val fragment = MergeCountFragment()
            val args = Bundle()
            args.putInt("type", type)
            args.putString("category", category)
            args.putInt("text_id", text_id)
            fragment.arguments = args
            return fragment
        }
    }
}