package com.example.nunettine.ui.save

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.databinding.FragmentMemoListBinding

class SaveMemoFragment: Fragment() {
    private lateinit var binding: FragmentMemoListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMemoListBinding.inflate(layoutInflater)
        initRV()
        return binding.root
    }

    private fun initRV() = with(binding) {
        val adapter = fragmentManager?.let { SaveMemoRVAdapter(requireContext(), it) }
        memoListRv.adapter = adapter
        memoListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}