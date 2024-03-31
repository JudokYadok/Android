package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentAddContentsBinding

class AddContentsFragment: Fragment() {
    private lateinit var binding: FragmentAddContentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Spinner
        val yearSpinner = binding.spinnerType
        val yearAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.type, android.R.layout.simple_spinner_item)
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yearSpinner.adapter = yearAdapter
        return binding.root
    }
}