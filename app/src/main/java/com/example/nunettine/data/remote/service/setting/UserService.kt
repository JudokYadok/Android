package com.example.nunettine.data.remote.service.setting

import android.util.Log
import com.example.nunettine.data.local.FeedbackReq
import com.example.nunettine.data.local.UserReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.setting.UserRes
import com.example.nunettine.data.remote.retrofit.SettingRetrofitInterface
import com.example.nunettine.data.remote.view.setting.FeedbackView
import com.example.nunettine.data.remote.view.setting.UserModifyView
import com.example.nunettine.data.remote.view.setting.UserView
import com.example.nunettine.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserService {
    private lateinit var userView: UserView
    private lateinit var userModifyView: UserModifyView
    private lateinit var feedbackView: FeedbackView

    fun setUserView(userview: UserView) {
        this.userView = userView
    }

    fun setUserModifyView(userModifyView: UserModifyView) {
        this.userModifyView = userModifyView
    }

    fun setFeedbackView(feedbackView: FeedbackView) {
        this.feedbackView = feedbackView
    }

    fun getUser(userId: Int) {
        val userService = getRetrofit().create(SettingRetrofitInterface::class.java)
        userService.getMyPage(userId).enqueue(object : Callback<UserRes> {
            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                if (response.isSuccessful) {
                    val resp: UserRes? = response.body()
                    if (resp != null) {
                        userView.onGetUserSuccess(resp)
                    } else {
                        Log.e("USER-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("USER-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                Log.d("USER-FAILURE", t.toString())
            }
        })
    }

    fun putUser(userReq: UserReq) {
        val userModifyService = getRetrofit().create(SettingRetrofitInterface::class.java)
        userModifyService.putMyPage(userReq).enqueue(object : Callback<BasicRes> {
            override fun onResponse(call: Call<BasicRes>, response: Response<BasicRes>) {
                if (response.isSuccessful) {
                    val resp: BasicRes? = response.body()
                    if (resp != null) {
                        userModifyView.onGetUserModifySuccess(resp)
                    } else {
                        Log.e("USER-MODIFY-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("USER-MODIFY-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BasicRes>, t: Throwable) {
                Log.d("USER-MODIFY-FAILURE", t.toString())
            }
        })
    }

    fun setFeedback(feedbackReq: FeedbackReq) {
        val feedbackService = getRetrofit().create(SettingRetrofitInterface::class.java)
        feedbackService.postFeedback(feedbackReq).enqueue(object : Callback<BasicRes> {
            override fun onResponse(call: Call<BasicRes>, response: Response<BasicRes>) {
                if (response.isSuccessful) {
                    val resp: BasicRes? = response.body()
                    if (resp != null) {
                        feedbackView.onGetFeedbackSuccess(resp)
                    } else {
                        Log.e("FEEDBACK-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("FEEDBACK-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BasicRes>, t: Throwable) {
                Log.d("FEEDBACK-FAILURE", t.toString())
            }
        })
    }
}