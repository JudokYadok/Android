package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("QuizReq")
data class QuizReq(
    val quiz_id: Int,
    val user_answer: ArrayList<Int>
)
