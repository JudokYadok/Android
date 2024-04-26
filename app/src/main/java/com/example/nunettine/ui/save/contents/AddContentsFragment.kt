package com.example.nunettine.ui.save.contents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentAddContentsBinding
import com.example.nunettine.ui.save.SaveFragment

class AddContentsFragment: Fragment() {
    private lateinit var binding: FragmentAddContentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddContentsBinding.inflate(layoutInflater)

        // Spinner
        val yearSpinner = binding.spinnerType
        val yearAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.type, android.R.layout.simple_spinner_item)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = yearAdapter

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        addContentsBackBtn.setOnClickListener {
            goBackFragment()
        }

        addContentsBtn.setOnClickListener {
            Toast.makeText(context, "지문이 저장되었습니다.", Toast.LENGTH_SHORT).show()
            goBackFragment()
        }
    }

    private fun goBackFragment() { parentFragmentManager.popBackStack() }
}