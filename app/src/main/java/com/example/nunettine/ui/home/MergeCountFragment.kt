package com.example.nunettine.ui.home

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nunettine.R
import com.example.nunettine.data.local.QuizReq
import com.example.nunettine.databinding.FragmentMergeCountBinding
import com.example.nunettine.ui.main.MainActivity
import com.example.nunettine.utils.LoadingDialog

class MergeCountFragment: Fragment() {
    private lateinit var binding: FragmentMergeCountBinding
    private lateinit var loadingDialog: LoadingDialog
    private lateinit var viewModel: HomeViewModel
    private var timer: CountDownTimer? = null
    private var type = ""
    private var category = ""
    private var text_id = 0
    private var text_title = ""
    private var quiz_type = ""
    private var quiz_make_ing = ""
    private var isClicked = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMergeCountBinding.inflate(layoutInflater)
        getData()
        loadingDialog = LoadingDialog(requireContext()) // 로딩 다이얼로그 초기화
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observeQuizMake()
        binding.mergeCountTv.text = text_title

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        mergeCountBackBtn.setOnClickListener { moveFragment(PreviewContentsFragment()) }

        mergeCountType1Btn.setOnClickListener {
            viewModel.quizTypeML.value = "content_match"
            observeQuizType()
            clickButton(mergeCountType1Btn)
        }
        mergeCountType2Btn.setOnClickListener {
            viewModel.quizTypeML.value = "content_pattern"
            observeQuizType()
            clickButton(mergeCountType2Btn)
        }
        mergeCountType3Btn.setOnClickListener {
            viewModel.quizTypeML.value = "content_understanding"
            observeQuizType()
            clickButton(mergeCountType3Btn)
        }
        mergeCountType4Btn.setOnClickListener {
            viewModel.quizTypeML.value = "target_comparison"
            observeQuizType()
            clickButton(mergeCountType4Btn)
        }
        mergeCountType5Btn.setOnClickListener {
            viewModel.quizTypeML.value = "all_types"
            observeQuizType()
            clickButton(mergeCountType5Btn)
        }

        mergeCountBtn.setOnClickListener {
            val quizT = QuizReq(quiz_type)
            if(type == "PREVTEXT") {
                Log.d("api", "${category}, ${text_id}, ${quiz_type}")
                viewModel.setPrevQuizTypeService(category, text_id, quizT)
                loadingDialog.show() // 로딩 다이얼로그 표시

                // api 호출 후 60초가 지났을 때
                // 타이머 시작
                timer = object : CountDownTimer(60000, 1000) { // 60초 타이머
                    override fun onTick(millisUntilFinished: Long) {
                        // 남은 시간에 따라 처리
                    }

                    override fun onFinish() {
                        // 60초가 지난 후 다이얼로그를 숨김
                        loadingDialog.dismiss()
                        Toast.makeText(context, "문제가 정상적으로 생성되지 않았습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                timer?.start()

                Log.d("TRUE", quiz_make_ing)
                if(quiz_make_ing == "true" || quiz_make_ing == "false") {
                    loadingDialog.dismiss()
                }
            } else {
//            setStudyMyDetailService(category, text_id)
            }
        }
    }

    private fun observeQuizMake(){
        viewModel.quizMakeML.observe(viewLifecycleOwner) { quizMake ->
            quiz_make_ing = quizMake
        }
    }

    private fun observeQuizType(){
        viewModel.quizTypeML.observe(viewLifecycleOwner) { quizType ->
            quiz_type = quizType
        }
    }

    private fun clickButton(clickedButton: Button) = with(binding) {
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
    }

    fun moveFragment(fragment: Fragment) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        // Fragment가 제거될 때 타이머를 취소합니다.
        timer?.cancel()
    }
}