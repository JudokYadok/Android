package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.local.FeedbackReq
import com.example.nunettine.data.local.UserReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.setting.UserRes
import retrofit2.Call
import retrofit2.http.*

interface SettingRetrofitInterface {
    @GET("/user/setting/mypage")
    fun getMyPage(@Body user_id: Int): Call<UserRes>

    @PUT("/user/setting/mypage")
    fun putMyPage(@Body userReq: UserReq): Call<BasicRes>

    @POST("/user/setting/feedback")
    fun postFeedback(@Body feedbackReq: FeedbackReq): Call<BasicRes>
}