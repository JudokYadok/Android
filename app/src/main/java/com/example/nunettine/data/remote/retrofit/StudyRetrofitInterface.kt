package com.example.nunettine.data.remote.retrofit

import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.dto.study.StudyListRes
import retrofit2.Call
import retrofit2.http.*

interface StudyRetrofitInterface {
    @GET("/user/study/prevtext/{category}")
    fun getPrevTextList(@Path("category") category: String): Call<StudyListRes>

    @GET("/user/study/mytext/{category}")
    fun getMyTextList(@Path("category") category: String): Call<StudyListRes>

    @GET("/user/study/prevtext/{category}/{text_id}")
    fun getPrevText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>

    @GET("/user/study/mytext/{category}/{text_id}")
    fun getMyText(@Path("category") category: String, @Path("text_id") text_id: Int): Call<StudyDetailRes>
}