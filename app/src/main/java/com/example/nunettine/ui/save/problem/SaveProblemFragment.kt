package com.example.nunettine.ui.save.problem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.databinding.FragmentProblemListBinding
import com.example.nunettine.ui.save.memo.SaveMemoRVAdapter

class SaveProblemFragment: Fragment() {
    private lateinit var binding: FragmentProblemListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProblemListBinding.inflate(layoutInflater)
        initRV()
        return binding.root
    }

    private fun initRV() = with(binding) {
        val adapter = fragmentManager?.let { SaveProblemRVAdapter(requireContext(), it) }
        problemListRv.adapter = adapter
        problemListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}