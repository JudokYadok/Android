package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.local.MemoReq
import com.example.nunettine.data.local.NewMemoReq
import com.example.nunettine.data.local.NewTextReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.library.MemoList
import com.example.nunettine.data.remote.dto.library.MemoListRes
import com.example.nunettine.data.remote.dto.library.MemoRes
import com.example.nunettine.data.remote.dto.library.QuizListRes
import com.example.nunettine.data.remote.dto.library.QuizRes
import com.example.nunettine.data.remote.dto.library.TextListRes
import com.example.nunettine.data.remote.dto.library.TextRes
import retrofit2.Call
import retrofit2.http.*

interface LibraryRetrofitInterface {
    @GET("/user/library/quiz")
    fun getQuizList(): Call<QuizListRes>

    @GET("/user/library/quiz/{quiz_id}")
    fun getQuiz(@Path("quiz_id") quiz_id: Int): Call<QuizRes>

    @GET("/user/library/memo")
    fun getMemoList(): Call<List<MemoList>>

    @GET("/user/library/memo/{memo_id}")
    fun getMemo(@Path("memo_id") memo_id: Int): Call<MemoRes>

    @PUT("/user/library/memo/{memo_id}")
    fun putMemo(@Path("memo_id") memo_id: Int, @Body memoReq: MemoReq): Call<BasicRes>

    @GET("/user/library/mytext")
    fun getMyTextList(): Call<TextListRes>

    @GET("/user/library/mytext/{text_id}")
    fun getMyText(@Path("text_id") text_id: Int): Call<TextRes>

    @PUT("/user/library/mytext/{text_id}")
    fun putMyText(@Path("text_id") text_id: Int, @Body myTextReq: NewTextReq): Call<BasicRes>

    @POST("/user/library/mytext/new")
    fun postMyText(@Body newTextReq: NewTextReq): Call<BasicRes>

    @POST("/user/library/memo")
    fun postMemo(@Body newMemoReq: NewMemoReq): Call<BasicRes>
}