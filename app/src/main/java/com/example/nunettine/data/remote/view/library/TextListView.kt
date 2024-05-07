package com.example.nunettine.data.remote.view.library

import com.example.nunettine.data.remote.dto.library.TextListRes

interface TextListView {
    fun onGetTextListSuccess(response: TextListRes)
    fun onGetTextListFailure(result_code: Int, result_req: String)
}