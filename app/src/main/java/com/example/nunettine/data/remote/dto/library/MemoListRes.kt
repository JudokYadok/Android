package com.example.nunettine.data.remote.dto.library

import com.google.gson.annotations.SerializedName

data class MemoListRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("memo_list") val memo_list: MemoList
)

data class MemoList(
    @SerializedName("memo_id") val memo_id: Int,
    @SerializedName("memo_title") val memo_title: String,
    @SerializedName("updated_at") val updated_at: String
)
