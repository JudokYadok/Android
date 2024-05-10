package com.example.nunettine.data.remote.view.library

import com.example.nunettine.data.remote.dto.library.QuizListRes

interface QuizListView {
    fun onGetQuizListSuccess(response: QuizListRes)
    fun onGetQuizListFailure(result_code: Int)
}