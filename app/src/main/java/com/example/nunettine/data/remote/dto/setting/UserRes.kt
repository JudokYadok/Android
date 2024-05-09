package com.example.nunettine.data.remote.dto.setting

import com.google.gson.annotations.SerializedName

data class UserRes(
    @SerializedName("user_name") val user_name: String,
    @SerializedName("user_email") val user_email: String,
    @SerializedName("user_birth") val user_birth: String, // d-day로 해야 하는 건지 문의
    @SerializedName("user_phone") val user_phone: String
)
