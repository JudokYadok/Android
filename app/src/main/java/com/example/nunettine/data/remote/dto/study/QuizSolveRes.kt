package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class QuizSolveRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("quiz_list") val quiz_list: ArrayList<String>,
    @SerializedName("quiz_answer") val quiz_answer: ArrayList<Int>
)
