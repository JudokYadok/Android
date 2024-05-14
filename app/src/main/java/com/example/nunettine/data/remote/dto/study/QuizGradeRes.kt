package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class QuizGradeRes(
    @SerializedName("context") val context: String,
    @SerializedName("response_metadata") val response_metadata: ResponseMetadata,
    @SerializedName("id") val id: String
)

data class ResponseMetadata(
    @SerializedName("token_usage") val token_usage: TokenUsage
)

data class TokenUsage(
    @SerializedName("completion_tokens") val completion_tokens: Int,
    @SerializedName("prompt_tokens") val prompt_tokens: Int,
    @SerializedName("total_tokens") val total_tokens: Int
)