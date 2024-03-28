package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.databinding.FragmentHomeVp1Binding

class HomeVP1Fragment: Fragment() {
    private lateinit var binding: FragmentHomeVp1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeVp1Binding.inflate(layoutInflater)
        return binding.root
    }
}