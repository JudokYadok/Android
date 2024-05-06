package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.local.LoginReq
import com.example.nunettine.data.remote.dto.auth.LoginRes
import retrofit2.Call
import retrofit2.http.*

interface AuthRetrofitInterface {
    @POST("/login")
    fun getLogin(@Body loginReq: LoginReq): Call<LoginRes>
}