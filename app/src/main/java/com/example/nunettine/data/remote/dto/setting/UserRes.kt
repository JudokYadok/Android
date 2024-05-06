package com.example.nunettine.data.remote.dto.setting

import com.google.gson.annotations.SerializedName

data class UserRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("user_name") val user_name: String,
    @SerializedName("user_email") val user_email: String,
    @SerializedName("user_birth") val user_birth: String, // d-day로 해야 하는 건지 문의
    @SerializedName("user_phone") val user_phone: String
)
