package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.local.QuizReq
import com.example.nunettine.data.remote.dto.study.QuizGradeRes
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.dto.study.StudyCategoryRes
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.StudyListRes
import retrofit2.Call
import retrofit2.http.*

interface StudyRetrofitInterface {
    @GET("/user/study/prevtext")
    fun getPrevTextType(): Call<StudyCategoryRes>

    @GET("/user/study/mytext")
    fun getMyTextType(): Call<StudyCategoryRes>

    @GET("/user/study/prevtext/{category}")
    fun getPrevTextList(@Path("category") category: String): Call<StudyListRes>

    @GET("/user/study/mytext/{category}")
    fun getMyTextList(@Path("category") category: String): Call<StudyListRes>

    @GET("/user/study/prevtext/{category}/{text_id}")
    fun getPrevText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>

    @GET("/user/study/mytext/{category}/{text_id}")
    fun getMyText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>

    @POST("/user/study/prevtext/{category}/{text_id}/newquiz")
    fun postPrevTextQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quiz_type: String): Call<QuizSolveRes>

    @POST("/user/study/mytext/{category}/{text_id}/newquiz")
    fun postMyTextQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quiz_type: String): Call<QuizSolveRes>

    @POST("/user/study/prevtext/{category}/{text_id}/newquiz/result")
    fun postPrevTextCheckQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quizReq: QuizReq): Call<QuizGradeRes>

    @POST("/user/study/mytext/{category}/{text_id}/newquiz/result")
    fun postMyTextCheckQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quizReq: QuizReq): Call<QuizGradeRes>
}