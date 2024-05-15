package com.example.nunettine.ui.home

import android.content.Context
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.R
import com.example.nunettine.data.local.QuizReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.library.QuizList
import com.example.nunettine.data.remote.dto.study.Question
import com.example.nunettine.data.remote.dto.study.QuizGradeRes
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.TextList
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.setting.FeedbackView
import com.example.nunettine.data.remote.view.study.QuizGradeView
import com.example.nunettine.data.remote.view.study.QuizSolveView
import com.example.nunettine.data.remote.view.study.StudyCategoryView
import com.example.nunettine.data.remote.view.study.StudyDetailView
import com.example.nunettine.data.remote.view.study.StudyListView
import com.example.nunettine.ui.main.MainActivity
import com.example.nunettine.utils.LoadingDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel(), StudyCategoryView, StudyListView, StudyDetailView, FeedbackView {
    // type
    val categoryListML = MutableLiveData<List<String>>()

    // text_list
    val textListML = MutableLiveData<List<TextList>>()

    // text
    val textTitleML = MutableLiveData<String>()
    val textContentsML = MutableLiveData<String>()

    // quiz_type
    val quizTypeML = MutableLiveData<String>()

    // quiz
    val quizMakeML = MutableLiveData<String>()
    val quizListML = MutableLiveData<List<Question>>()
    val quizUserAnswer1ML = MutableLiveData<Int>()
    val quizUserAnswer2ML = MutableLiveData<Int>()
    val quizUserAnswer3ML = MutableLiveData<Int>()

    // quiz summary
    val quizSummaryML = MutableLiveData<String>()

    init {
        categoryListML.value = emptyList()
        textListML.value = emptyList()
        textTitleML.value = String()
        textContentsML.value = String()
        quizTypeML.value = String()
        quizListML.value = emptyList()
        quizMakeML.value = String()
        quizSummaryML.value = String()
    }

    fun setMyTypeService() {
        val setStudyCategoryService = QuizService()
        setStudyCategoryService.getStudyCategoryView(this@HomeViewModel)
        setStudyCategoryService.getMyTextCategory()
    }

    fun setPrevTypeService() {
        val setStudyCategoryService = QuizService()
        setStudyCategoryService.getStudyCategoryView(this@HomeViewModel)
        setStudyCategoryService.getPrevTextCategory()
    }

    fun setMyChooseService(category: String) {
        val setStudyListService = QuizService()
        setStudyListService.getStudyListView(this@HomeViewModel)
        setStudyListService.getMyTextList(category)
    }

    fun setPrevChooseService(category: String) {
        val setStudyListService = QuizService()
        setStudyListService.getStudyListView(this@HomeViewModel)
        setStudyListService.getPrevTextList(category)
    }

    fun setStudyMyDetailService(category:String, text_id: Int) {
        val setStudyDetailService = QuizService()
        setStudyDetailService.getStudyDetailView(this@HomeViewModel)
        setStudyDetailService.getMyText(category, text_id)
    }

    fun setStudyPrevDetailService(category: String, text_id: Int) {
        val setStudyDetailService = QuizService()
        setStudyDetailService.getStudyDetailView(this@HomeViewModel)
        setStudyDetailService.getPrevText(category, text_id)
    }

    fun setStudyFeedbackService(user_id: Int, quiz_id: Int) {
        val setStudyFeedbackService = QuizService()
        setStudyFeedbackService.setFeedbackView(this@HomeViewModel)
        setStudyFeedbackService.setQuizFeedback(user_id, quiz_id)
    }

    override fun onGetStudyCategorySuccess(response: List<String>) {
        categoryListML.postValue(response)
        Log.d("TYPE-GET-성공", response.toString())
    }

    override fun onGetStudyCategoryFailure(result_code: Int) {
        Log.d("TYPE-GET-오류", result_code.toString())
    }

    override fun onGetStudyListSuccess(response: List<TextList>) {
        textListML.postValue(response)
        Log.d("TEXT-LIST-성공", response.toString())
    }

    override fun onGetStudyListFailure(result_code: Int) {
        Log.d("TEXT-LIST-오류", result_code.toString())
    }

    override fun onGetStudyDetailSuccess(response: StudyDetailRes) {
        textTitleML.postValue(response.title)
        textContentsML.postValue(response.contents)
        Log.d("TEXT-DETAIL-성공", response.toString())
    }

    override fun onGetStudyDetailFailure(result_code: Int) {
        Log.d("TEXT-DETAIL-오류", result_code.toString())
    }

    override fun onGetFeedbackSuccess(response: BasicRes) {
        Log.d("QUIZ-FEEDBACK-성공", response.toString())
    }

    override fun onGetFeedbackFailure(result_code: Int) {
        Log.d("QUIZ-FEEDBACK-오류", result_code.toString())
    }
}