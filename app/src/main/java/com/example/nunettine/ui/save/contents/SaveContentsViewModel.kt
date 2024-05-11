package com.example.nunettine.ui.save.contents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.data.remote.dto.BasicRes
import com.example.nunettine.data.remote.dto.library.TextList
import com.example.nunettine.data.remote.dto.library.TextListRes
import com.example.nunettine.data.remote.dto.library.TextRes
import com.example.nunettine.data.remote.view.library.TextListView
import com.example.nunettine.data.remote.view.library.TextModifyView
import com.example.nunettine.data.remote.view.library.TextNewView
import com.example.nunettine.data.remote.view.library.TextView

class SaveContentsViewModel: ViewModel(), TextListView, TextView, TextModifyView, TextNewView {
    // 전체 조회
    val textListML = MutableLiveData<List<TextList>>()


    override fun onGetTextListSuccess(response: TextListRes) {
        TODO("Not yet implemented")
    }

    override fun onGetTextListFailure(result_code: Int) {
        TODO("Not yet implemented")
    }

    override fun onGetTextModifySuccess(response: BasicRes) {
        TODO("Not yet implemented")
    }

    override fun onGetTextModifyFailure(result_code: Int) {
        TODO("Not yet implemented")
    }

    override fun onGetTextNewSuccess(response: BasicRes) {
        TODO("Not yet implemented")
    }

    override fun onGetTextNewFailure(result_code: Int) {
        TODO("Not yet implemented")
    }

    override fun onGetTextSuccess(response: TextRes) {
        TODO("Not yet implemented")
    }

    override fun onGetTextFailure(result_code: Int) {
        TODO("Not yet implemented")
    }
}