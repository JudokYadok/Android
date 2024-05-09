package com.example.nunettine.data.remote.service.auth

import android.util.Log
import com.example.nunettine.data.local.LoginReq
import com.example.nunettine.data.remote.dto.auth.LoginRes
import com.example.nunettine.data.remote.retrofit.AuthRetrofitInterface
import com.example.nunettine.data.remote.view.auth.LoginView
import com.example.nunettine.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var loginView: LoginView

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun setLogin(loginReq: LoginReq) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.getLogin(loginReq).enqueue(object : Callback<LoginRes> {
            override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
                if (response.isSuccessful) {
                    val resp: LoginRes? = response.body()
                    if (resp != null) {
                        loginView.onGetLoginSuccess(resp)
                    } else {
                        Log.e("LOGIN-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("LOGIN-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                Log.d("LOGIN-FAILURE", t.toString())
            }
        })
    }
}