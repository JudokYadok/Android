package com.example.nunettine.data.remote.dto.study

import com.google.gson.annotations.SerializedName

data class StudyCategoryRes(
    @SerializedName("content_type") val content_type: String,
    @SerializedName("result_code") val result_code: Int,
    @SerializedName("result_req") val result_req: String,
    @SerializedName("category_list") val category_list: ArrayList<String>
)
