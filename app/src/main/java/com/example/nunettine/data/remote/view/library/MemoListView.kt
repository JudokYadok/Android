package com.example.nunettine.data.remote.view.library

import com.example.nunettine.data.remote.dto.library.MemoListRes

interface MemoListView {
    fun onGetMemoListSuccess(reponse: MemoListRes)
    fun onGetMemoListFailure(result_code: Int, result_req: String)
}