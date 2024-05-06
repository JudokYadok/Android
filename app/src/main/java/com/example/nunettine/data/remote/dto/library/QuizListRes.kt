package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class QuizListRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("quiz_list") val quiz_list: QuizList
)

data class QuizList(
    @SerializedName("quiz_id") val quiz_id: Int,
    @SerializedName("text_title") val text_title: String,
    @SerializedName("score") val score: Int,
    @SerializedName("updated_at") val updated_at: String
)
