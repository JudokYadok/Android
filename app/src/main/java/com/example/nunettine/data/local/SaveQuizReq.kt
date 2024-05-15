package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("SaveQuizReq")
data class SaveQuizReq (
    val text_title: String,
    val text_contents: String,
    val quiz_list: List<QuizLists>,
    val quiz_summary: String
)

data class QuizLists (
    val question_list: List<String>,
    val answer_list: AnswerList,
    val user_answer_list: List<Int>,
    val ai_answer_list: List<Int>
)

data class AnswerList (
    val answer_list1: List<String>,
    val answer_list2: List<String>,
    val answer_list3: List<String>
)