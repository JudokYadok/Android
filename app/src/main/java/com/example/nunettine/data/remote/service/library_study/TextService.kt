package com.example.nunettine.data.remote.service.library_study

import android.util.Log
import com.example.nunettine.data.local.NewTextReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.library.TextListRes
import com.example.nunettine.data.remote.dto.library.TextRes
import com.example.nunettine.data.remote.retrofit.LibraryRetrofitInterface
import com.example.nunettine.data.remote.view.library.TextListView
import com.example.nunettine.data.remote.view.library.TextModifyView
import com.example.nunettine.data.remote.view.library.TextNewView
import com.example.nunettine.data.remote.view.library.TextView
import com.example.nunettine.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TextService {
    private lateinit var textView: TextView
    private lateinit var textListView: TextListView
    private lateinit var textNewView: TextNewView
    private lateinit var textModifyView: TextModifyView

    fun setTextView(textView: TextView) {
        this.textView = textView
    }

    fun setTextListView(textListView: TextListView) {
        this.textListView = textListView
    }

    fun setTextNewView(textNewView: TextNewView) {
        this.textNewView = textNewView
    }

    fun setTextModifyView(textModifyView: TextModifyView) {
        this.textModifyView = textModifyView
    }

    fun getText(textId: Int) {
        val textService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        textService.getMyText(textId).enqueue(object : Callback<TextRes> {
            override fun onResponse(call: Call<TextRes>, response: Response<TextRes>) {
                if (response.isSuccessful) {
                    val resp: TextRes? = response.body()
                    if (resp != null) {
                        when (resp.result_code) {
                            123 -> textView.onGetTextSuccess(resp)
                            else -> textView.onGetTextFailure(resp.result_code, resp.result_req)
                        }
                    } else {
                        Log.e("TEXT-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("TEXT-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<TextRes>, t: Throwable) {
                Log.d("TEXT-FAILURE", t.toString())
            }
        })
    }

    fun getTextList() {
        val textListService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        textListService.getMyTextList().enqueue(object : Callback<TextListRes> {
            override fun onResponse(call: Call<TextListRes>, response: Response<TextListRes>) {
                if (response.isSuccessful) {
                    val resp: TextListRes? = response.body()
                    if (resp != null) {
                        when (resp.result_code) {
                            123 -> textListView.onGetTextListSuccess(resp)
                            else -> textListView.onGetTextListFailure(resp.result_code, resp.result_req)
                        }
                    } else {
                        Log.e("TEXT-LIST-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("TEXT-LIST-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<TextListRes>, t: Throwable) {
                Log.d("TEXT-LIST-FAILURE", t.toString())
            }
        })
    }

    fun setText(newTextReq: NewTextReq) {
        val textNewService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        textNewService.postMyText(newTextReq).enqueue(object : Callback<BasicRes> {
            override fun onResponse(call: Call<BasicRes>, response: Response<BasicRes>) {
                if (response.isSuccessful) {
                    val resp: BasicRes? = response.body()
                    if (resp != null) {
                        textNewView.onGetTextNewSuccess(resp)
                    } else {
                        Log.e("TEXT-NEW-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("TEXT-NEW-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BasicRes>, t: Throwable) {
                Log.d("TEXT-NEW-FAILURE", t.toString())
            }
        })
    }

    fun putText(textId: Int, myTextReq: NewTextReq) {
        val textModifyService = getRetrofit().create(LibraryRetrofitInterface::class.java)
        textModifyService.putMyText(textId, myTextReq).enqueue(object : Callback<BasicRes> {
            override fun onResponse(call: Call<BasicRes>, response: Response<BasicRes>) {
                if (response.isSuccessful) {
                    val resp: BasicRes? = response.body()
                    if (resp != null) {
                        textModifyView.onGetTextModifySuccess(resp)
                    } else {
                        Log.e("TEXT-MODIFY-SUCCESS", "Response body is null")
                    }
                } else {
                    Log.e("TEXT-MODIFY-SUCCESS", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<BasicRes>, t: Throwable) {
                Log.d("TEXT-MODIFY-FAILURE", t.toString())
            }
        })
    }
}