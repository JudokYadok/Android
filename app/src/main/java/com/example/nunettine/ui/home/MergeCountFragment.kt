package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentMergeCountBinding
import com.example.nunettine.ui.main.MainActivity

class MergeCountFragment: Fragment() {
    private lateinit var binding: FragmentMergeCountBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMergeCountBinding.inflate(layoutInflater)

        clickListener()

        return binding.root
    }

    private fun clickListener() = with(binding) {
        mergeCountBackBtn.setOnClickListener { goBackFragment() }

        mergeCountType1Btn.setOnClickListener { clickButton(mergeCountType1Btn) }
        mergeCountType2Btn.setOnClickListener { clickButton(mergeCountType2Btn) }
        mergeCountType3Btn.setOnClickListener { clickButton(mergeCountType3Btn) }
        mergeCountType4Btn.setOnClickListener { clickButton(mergeCountType4Btn) }
        mergeCountType5Btn.setOnClickListener { clickButton(mergeCountType5Btn) }

        mergeCountBtn.setOnClickListener { moveFragment(ProblemFragment()) }
    }

    private fun clickButton(clickedButton: Button) = with(binding) {
        val buttons = listOf(
            mergeCountType1Btn,
            mergeCountType2Btn,
            mergeCountType3Btn,
            mergeCountType4Btn,
            mergeCountType5Btn
        )

        buttons.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
        mergeCountBtn.isEnabled = true
    }

    private fun moveFragment(fragment: Fragment) {
        val mainActivity = context as MainActivity
        val mainFrmLayout = mainActivity.findViewById<FrameLayout>(R.id.main_frm) as FrameLayout?
        if (mainFrmLayout != null) {
            val transaction = mainActivity.supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            transaction.replace(mainFrmLayout.id, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun goBackFragment() {
        parentFragmentManager.popBackStack()
    }
}