package com.example.nunettine.ui.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {
    val profileML = MutableLiveData<String>().apply {
        setValue(DEFAULT_IMG)
    }

    companion object {
        val DEFAULT_IMG = "https://k.kakaocdn.net/dn/1G9kp/btsAot8liOn/8CWudi3uy07rvFNUkk3ER0/img_640x640.jpg"
    }
}