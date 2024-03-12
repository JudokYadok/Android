package com.example.nunettine.ui.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.nunettine.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var nickname : String? = ""
    private var profile :String? = ""
    private var email: String? = ""
    private var accessToken: String? = ""
    private var member_id: Int? = 0
    private var getAccessToken: String? = ""
    private var getRefreshToken: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginKakaoBtn.setOnClickListener {
            login_kakao()
        }
    }

    private fun login_kakao() {
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        // 이메일 로그인 콜백
        val mCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패 $error")
            } else if (token != null) {
                Log.e(TAG, "로그인 성공 ${token.accessToken}")

                UserApiClient.instance.me { user, _ ->
                    if (user != null) {
                        nickname = user.kakaoAccount?.profile?.nickname.toString()
                        profile = user.kakaoAccount?.profile?.profileImageUrl.toString()
                        email = user.kakaoAccount?.email
                        accessToken = token.accessToken
                        Log.d("TAG", "$nickname, $profile, $email, $accessToken")
                        saveKakaoData()
                    }
                }
                goMainActivity()
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            // 카카오톡 로그인
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                // 로그인 실패 부분
                if (error != null) {
                    Log.e(TAG, "로그인 실패 $error")
                    // 사용자가 취소
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled ) {
                        return@loginWithKakaoTalk
                    }
                    // 다른 오류
                    else {
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback) // 카카오 이메일 로그인
                    }
                }
                // 로그인 성공 부분
                else if (token != null) {
                    Log.e(TAG, "로그인 성공 ${token.accessToken}")
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback) // 카카오 이메일 로그인
        }
    }

    private fun saveKakaoData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("kakao", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("nickname", nickname!!)
        editor.putString("profile", profile!!)
        editor.putString("email", email!!)
        editor.putString("accessToken", accessToken!!)
        editor.apply()
    }

    private fun goMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        var TAG = "LoginActivity"
    }
}