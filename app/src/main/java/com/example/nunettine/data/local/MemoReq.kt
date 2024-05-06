package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("MemoReq")
data class MemoReq(
    val memo_id: Int,
    val memo_title: String,
    val memo_contents: String
)
