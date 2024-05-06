package com.example.nunettine.data.remote.dto

import com.google.gson.annotations.SerializedName

data class BasicRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String
)
