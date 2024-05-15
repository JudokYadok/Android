package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.local.QuizReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.study.QuizGradeRes
import com.example.nunettine.data.remote.dto.study.QuizSolveRes
import com.example.nunettine.data.remote.dto.study.StudyCategoryRes
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.StudyListRes
import com.example.nunettine.data.remote.dto.study.TextList
import retrofit2.Call
import retrofit2.http.*

interface StudyRetrofitInterface {
    @GET("/user/study/prevtext")
    fun getPrevTextType(): Call<List<String>>

    @GET("/user/study/mytext")
    fun getMyTextType(): Call<List<String>>

    @GET("/user/study/prevtext/{category}")
    fun getPrevTextList(@Path("category") category: String): Call<List<TextList>>

    @GET("/user/study/mytext/{category}")
    fun getMyTextList(@Path("category") category: String): Call<List<TextList>>

    @GET("/user/study/prevtext/{category}/{text_id}")
    fun getPrevText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>

    @GET("/user/study/mytext/{category}/{text_id}")
    fun getMyText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>

    @POST("/user/study/prevtext/{category}/{text_id}/quiz")
    fun postPrevTextQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quiz_type: QuizReq): Call<QuizSolveRes>

    @POST("/user/study/mytext/{category}/{text_id}/quiz")
    fun postMyTextQuiz(@Path("category") category: String, @Path("text_id") text_id: Int, @Body quiz_type: QuizReq): Call<QuizSolveRes>

    @POST("/user/study/prevtext/{category}/{text_id}/quiz/mark")
    fun postPrevTextCheckQuiz(@Path("category") category: String, @Path("text_id") text_id: Int): Call<QuizGradeRes>

    @POST("/user/study/mytext/{category}/{text_id}/quiz/mark")
    fun postMyTextCheckQuiz(@Path("category") category: String, @Path("text_id") text_id: Int): Call<QuizGradeRes>

    @POST("user/study/quizfeedback/{user_id}/{quiz_id}")
    fun postQuizFeedback(@Path("user_id") user_id: Int, @Path("quiz_id") quiz_id: Int): Call<BasicRes>
}