package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.databinding.FragmentChooseBinding

class ChooseFragment: Fragment() {
    private lateinit var binding: FragmentChooseBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChooseBinding.inflate(layoutInflater)
        clickListner()
        initRV()
        return binding.root
    }

    private fun initRV() = with(binding){
        val chooseRVAdapter = ChooseRVAdapter(requireContext(), parentFragmentManager)
        // RecyclerView 어댑터 설정
        chooseRv.layoutManager = LinearLayoutManager(requireContext())
        // RecyclerView 레이아웃 매니저 설정
        chooseRv.adapter = chooseRVAdapter
    }

    private fun clickListner() = with(binding) {
        chooseBackBtn.setOnClickListener { goBackFragment() }
    }

    private fun goBackFragment() {
        parentFragmentManager.popBackStack()
    }
}