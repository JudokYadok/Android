package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class TextRes(
    @SerializedName("category") val text_category: String,
    @SerializedName("title") val text_title: String,
    @SerializedName("contents") val text_contents: String
)
