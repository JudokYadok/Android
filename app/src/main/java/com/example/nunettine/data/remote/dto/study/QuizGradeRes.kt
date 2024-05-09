package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class QuizGradeRes(
    @SerializedName("quiz_answer") val quiz_answer: ArrayList<Int>,
    @SerializedName("correct_num") val correct_num: Int,
    @SerializedName("wrong_num") val wrong_num: Int
)
