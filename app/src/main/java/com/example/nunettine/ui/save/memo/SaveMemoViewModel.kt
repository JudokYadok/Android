package com.example.nunettine.ui.save.memo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.data.local.MemoReq
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.library.MemoList
import com.example.nunettine.data.remote.dto.library.MemoRes
import com.example.nunettine.data.remote.service.library_study.MemoService
import com.example.nunettine.data.remote.view.library.MemoListView
import com.example.nunettine.data.remote.view.library.MemoModifyView
import com.example.nunettine.data.remote.view.library.MemoView

class SaveMemoViewModel:  ViewModel(), MemoListView, MemoView, MemoModifyView {
    val memoListML = MutableLiveData<List<MemoList>>()
    val memoTitleML = MutableLiveData<String>()
    val memoContentsML = MutableLiveData<String>()

    init {
        memoListML.value = emptyList()
        memoTitleML.value = String()
        memoContentsML.value = String()
    }

    fun getMemoListService() {
        val memoListService = MemoService()
        memoListService.setMemoListView(this@SaveMemoViewModel)
        memoListService.getMemoList()
    }

    fun getMemoService(memoId: Int) {
        val memoService = MemoService()
        memoService.setMemoView(this@SaveMemoViewModel)
        memoService.getMemo(memoId)
    }

    fun modifyMemoSerivce(memoId: Int, memoReq: MemoReq) {
        val modifyMemoSerivce = MemoService()
        modifyMemoSerivce.setMemoModifyView(this@SaveMemoViewModel)
        modifyMemoSerivce.putMemo(memoId, memoReq)
    }

    override fun onGetMemoListSuccess(response: List<MemoList>) {
        memoListML.postValue(response)
        Log.d("MEMO-LIST-성공", response.toString())
    }

    override fun onGetMemoListFailure(result_code: Int) {
        Log.d("MEMO-LIST-오류", result_code.toString())
    }

    override fun onGetMemoSuccess(response: MemoRes) {
        memoTitleML.postValue(response.title)
        memoContentsML.postValue(response.contents)
        Log.d("MEMO-GET-성공", response.toString())
    }

    override fun onGetMemoFailure(result_code: Int) {
        Log.d("MEMO-GET-오류", result_code.toString())
    }

    override fun onGetMemoModifySuccess(response: BasicRes) {
        Log.d("MEMO-MODIFY-성공", response.toString())
    }

    override fun onGetMemoModifyFailure(result_code: Int) {
        Log.d("MEMO-MODIFY-오류", result_code.toString())
    }
}