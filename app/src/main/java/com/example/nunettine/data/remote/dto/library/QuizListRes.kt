package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class QuizListRes(
    @SerializedName("quiz_list") val quiz_list: List<QuizList>
)

data class QuizList(
    @SerializedName("quiz_id") val quiz_id: Int,
    @SerializedName("text_title") val text_title: String,
    @SerializedName("score") val score: Int,
    @SerializedName("updated_at") val updated_at: String
)
