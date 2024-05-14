package com.example.nunettine.data.remote.view.setting

import com.example.nunettine.data.remote.dto.BasicRes

interface UserDeleteView {
    fun onGetUserDeleteSuccess(response: BasicRes)
    fun onGetUserDeleteFailure(result_code: Int)
}