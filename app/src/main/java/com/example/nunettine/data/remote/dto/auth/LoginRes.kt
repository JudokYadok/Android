package com.example.nunettine.data.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class LoginRes(
    @SerializedName("login_result") val login_result: LoginResult
)

data class LoginResult(
    @SerializedName("user_id") val user_id: Int,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("access_token") val access_token: String,
    @SerializedName("refresh_token") val refresh_token: String
)