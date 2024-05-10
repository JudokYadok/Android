package com.example.nunettine.data.remote.view.study

import com.example.nunettine.data.remote.dto.study.StudyListRes

interface StudyListView {
    fun onGetStudyListSuccess(response: StudyListRes)
    fun onGetStudyListFailure(result_code: Int)
}