package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class TextRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("text_category") val text_category: String,
    @SerializedName("text_title") val text_title: String,
    @SerializedName("text_contents") val text_contents: String
)
