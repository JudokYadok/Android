package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.remote.dto.auth.LoginRes
import retrofit2.Call
import retrofit2.http.*

interface AuthRetrofitInterface {
    @GET("/user/login")
    fun getLogin(@Header("authorization") authorization: String): Call<LoginRes>
}