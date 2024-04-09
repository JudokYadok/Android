package com.example.nunettine.ui.home.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nunettine.CircleTransform
import com.example.nunettine.ui.home.HomeFragment
import com.squareup.picasso.Picasso

class HomeViewModel(): ViewModel() {
    val profileML = MutableLiveData<String>().apply {
        setValue(DEFAULT_IMG)
    }

    companion object {
        val DEFAULT_IMG = "https://k.kakaocdn.net/dn/1G9kp/btsAot8liOn/8CWudi3uy07rvFNUkk3ER0/img_640x640.jpg"
    }
}