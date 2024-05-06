package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("UserReq")
data class UserReq(
    val user_id: Int,
    val user_name: String,
    val user_email: String,
    val user_birth: String,
    val user_phone: String
)
