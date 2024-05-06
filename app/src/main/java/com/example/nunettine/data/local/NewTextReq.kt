package com.example.nunettine.data.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("NewTextReq")
data class NewTextReq(
    val text_title: String,
    val text_category: String,
    val text_contents: String
)
