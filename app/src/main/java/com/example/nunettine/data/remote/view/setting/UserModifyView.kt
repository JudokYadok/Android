package com.example.nunettine.data.remote.view.setting

import com.example.nunettine.data.remote.dto.BasicRes

interface UserModifyView {
    fun onGetUserModifySuccess(response: BasicRes)
    fun onGetUserModifyFailure(result_code: Int)
}