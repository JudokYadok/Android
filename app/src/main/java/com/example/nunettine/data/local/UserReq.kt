package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("UserReq")
data class UserReq(
    val name: String,
    val email: String,
    val d_day: Int,
    val user_id: Int
)
