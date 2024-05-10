package com.example.nunettine.ui.save.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.data.remote.dto.library.MemoList
import com.example.nunettine.databinding.FragmentMemoListBinding

class SaveMemoFragment: Fragment() {
    private lateinit var binding: FragmentMemoListBinding
    private lateinit var viewModel: SaveMemoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMemoListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(SaveMemoViewModel::class.java)
        viewModel.getMemoListService()
        observeMemoList()
        return binding.root
    }

    private fun initRV(memoList: List<MemoList>) = with(binding) {
        val adapter = fragmentManager?.let { SaveMemoRVAdapter(requireContext(), memoList.toMutableList()) }
        memoListRv.adapter = adapter
        memoListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeMemoList() {
        viewModel.memoListML.observe(viewLifecycleOwner, Observer {
            it?.let { memoList ->
                initRV(memoList)
            }
        })
    }
}