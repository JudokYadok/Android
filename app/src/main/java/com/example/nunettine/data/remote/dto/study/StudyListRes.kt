package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class StudyListRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("text_list") val text_list: TextList
)

data class TextList(
    @SerializedName("text_id") val text_id: Int,
    @SerializedName("title") val title: String
)
