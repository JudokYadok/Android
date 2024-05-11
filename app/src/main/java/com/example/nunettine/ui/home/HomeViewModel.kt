package com.example.nunettine.ui.home

import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.TextList
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.QuizSolveView
import com.example.nunettine.data.remote.view.study.StudyCategoryView
import com.example.nunettine.data.remote.view.study.StudyDetailView
import com.example.nunettine.data.remote.view.study.StudyListView

class HomeViewModel(): ViewModel(), StudyCategoryView, StudyListView, StudyDetailView,
    QuizSolveView {
    // type
    val categoryListML = MutableLiveData<List<String>>()

    // text_list
    val textListML = MutableLiveData<List<TextList>>()

    // text
    val textTitleML = MutableLiveData<String>()
    val textContentsML = MutableLiveData<String>()

    init {
        categoryListML.value = emptyList()
        textListML.value = emptyList()
        textTitleML.value = String()
        textContentsML.value = String()
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

    fun setPrevQuizTypeService(category: String, text_id: Int, quiz_type: String) {
        val setPrevQuizTypeService = QuizService()
        setPrevQuizTypeService.setQuizSolveView(this@HomeViewModel)
        setPrevQuizTypeService.setPrevQuizSolve(category, text_id, quiz_type)
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

    override fun onGetQuizSolveSuccess(response: QuizSolveRes) {
        Log.d("QUIZ-MAKE-성공", response.toString())
    }

    override fun onGetQuizSolveFailure(result_code: Int) {
        Log.d("QUIZ-MAKE-오류", result_code.toString())
    }
}