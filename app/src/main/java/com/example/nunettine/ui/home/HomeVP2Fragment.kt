package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.databinding.FragmentHomeVp2Binding

class HomeVP2Fragment: Fragment() {
    private lateinit var binding: FragmentHomeVp2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeVp2Binding.inflate(layoutInflater)
        return binding.root
    }
}