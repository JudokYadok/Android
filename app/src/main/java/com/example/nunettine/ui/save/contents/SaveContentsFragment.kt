package com.example.nunettine.ui.save.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentContentsListBinding

class SaveContentsFragment : Fragment() {
    private lateinit var binding: FragmentContentsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContentsListBinding.inflate(layoutInflater)
        initRV()
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        contentsListBtn.setOnClickListener { moveFragment(AddContentsFragment()) }
    }

    private fun initRV() = with(binding) {
        val adapter = fragmentManager?.let { SaveContentsRVAdapter(requireContext(), it) }
        contentsListRv.adapter = adapter
        contentsListRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun moveFragment(fragment: Fragment) {
        val mainFrmLayout = activity?.findViewById<FrameLayout>(R.id.main_frm)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        mainFrmLayout?.id?.let { transaction?.replace(it, fragment) }
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}