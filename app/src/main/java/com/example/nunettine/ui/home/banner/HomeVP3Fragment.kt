package com.example.nunettine.ui.home.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.databinding.FragmentHomeVp3Binding

class HomeVP3Fragment: Fragment() {
    private lateinit var binding: FragmentHomeVp3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeVp3Binding.inflate(layoutInflater)
        return binding.root
    }
}