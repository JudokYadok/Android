package com.example.nunettine.data.remote.view.setting

import com.example.nunettine.data.remote.dto.BasicRes

interface FeedbackView {
    fun onGetFeedbackSuccess(response: BasicRes)
    fun onGetFeedbackFailure(result_code: Int)
}