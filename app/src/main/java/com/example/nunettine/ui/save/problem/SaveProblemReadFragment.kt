package com.example.nunettine.ui.save.problem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.databinding.FragmentSaveProblemBinding

class SaveProblemReadFragment: Fragment() {
    private lateinit var binding: FragmentSaveProblemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSaveProblemBinding.inflate(layoutInflater)

        clickListener()
        return binding.root
    }

    // 저장한 문제 가져오기 API (get) -> omt setting 필요

    private fun clickListener() = with(binding) {
        problemBackBtn.setOnClickListener { goBackFragment() }
    }
    private fun goBackFragment() { parentFragmentManager.popBackStack() }
}