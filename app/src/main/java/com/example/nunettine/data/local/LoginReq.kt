package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("LoginReq")
data class LoginReq(
    val user_email: String,
    val user_name: String
)
