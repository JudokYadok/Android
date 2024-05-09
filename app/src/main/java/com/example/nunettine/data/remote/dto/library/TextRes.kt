package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class TextRes(
    @SerializedName("text_category") val text_category: String,
    @SerializedName("text_title") val text_title: String,
    @SerializedName("text_contents") val text_contents: String
)
