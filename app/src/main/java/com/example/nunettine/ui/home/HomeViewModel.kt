package com.example.nunettine.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.TextList
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.StudyCategoryView
import com.example.nunettine.data.remote.view.study.StudyDetailView
import com.example.nunettine.data.remote.view.study.StudyListView

class HomeViewModel(): ViewModel(), StudyCategoryView, StudyListView, StudyDetailView {
    // home
    val profileML = MutableLiveData<String>()

    // type
    val categoryListML = MutableLiveData<List<String>>()

    // text_list
    val textListML = MutableLiveData<List<TextList>>()

    // text
    val textTitleML = MutableLiveData<String>()
    val textContentsML = MutableLiveData<String>()

    init {
        profileML.value = DEFAULT_IMG
        categoryListML.value = emptyList()
        textListML.value = emptyList()
        textTitleML.value = String()
        textContentsML.value = String()
    }

    fun setPrevTypeService() {
        val setStudyCategoryService = QuizService()
        setStudyCategoryService.getStudyCategoryView(this@HomeViewModel)
        setStudyCategoryService.getPrevTextCategory()
    }

    fun setPrevChooseService(category: String) {
        val setStudyListService = QuizService()
        setStudyListService.getStudyListView(this@HomeViewModel)
        setStudyListService.getPrevTextList(category)
    }

    fun setStudyPrevDetailService(category: String, text_id: Int) {
        val setStudyDetailService = QuizService()
        setStudyDetailService.getStudyDetailView(this@HomeViewModel)
        setStudyDetailService.getPrevText(category, text_id)
    }

    companion object {
        val DEFAULT_IMG = "https://k.kakaocdn.net/dn/1G9kp/btsAot8liOn/8CWudi3uy07rvFNUkk3ER0/img_640x640.jpg"
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
        textTitleML.postValue(response.text_title)
        textContentsML.postValue(response.text_contents)
        Log.d("TEXT-DETAIL-성공", response.toString())
    }

    override fun onGetStudyDetailFailure(result_code: Int) {
        Log.d("TEXT-DETAIL-오류", result_code.toString())
    }
}