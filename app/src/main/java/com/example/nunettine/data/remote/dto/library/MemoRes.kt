package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class MemoRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("memo_title") val memo_title: String,
    @SerializedName("memo_contents") val memo_contents: String
)
