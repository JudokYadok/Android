package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.databinding.FragmentChooseBinding

class ChooseFragment: Fragment() {
    private lateinit var binding: FragmentChooseBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChooseBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun clickListner() = with(binding) {
        chooseBackBtn.setOnClickListener { goBackFragment() }
    }

    private fun goBackFragment() {
        parentFragmentManager.popBackStack()
    }
}