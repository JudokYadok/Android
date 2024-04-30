package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentMemoBinding
import com.example.nunettine.ui.main.MainActivity

class MemoFragment: Fragment() {
    private lateinit var binding: FragmentMemoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMemoBinding.inflate(layoutInflater)

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        addMemoBackBtn.setOnClickListener { goBackFragment() }
        addMemoBtn.setOnClickListener {
            Toast.makeText(context, "메모가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            moveFragment(ProblemFragment())
        }
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