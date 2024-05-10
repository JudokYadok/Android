package com.example.nunettine.data.remote.view.library

import com.example.nunettine.data.remote.dto.library.QuizRes

interface QuizView {
    fun onGetQuizSuccess(response: QuizRes)
    fun onGetQuizFailure(result_code: Int)
}