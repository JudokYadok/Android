package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class QuizSolveRes(
    @SerializedName("quiz_list") val quiz_list: ArrayList<String>,
    @SerializedName("quiz_answer") val quiz_answer: ArrayList<Int>
)
