package com.example.nunettine.ui.save.contents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentModifyContentsBinding

class ModifyContentsFragment: Fragment() {
    private lateinit var binding: FragmentModifyContentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentModifyContentsBinding.inflate(layoutInflater)
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        modifyContentsBackBtn.setOnClickListener {
            goBackFragment()
        }

        modifyContentsBtn.setOnClickListener {
            // 지문 수정 저장
            Toast.makeText(context, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            super.onDestroy()
        }
    }

    private fun modifyContents() {
        // 변경사항이 있는 지문 저장 api 호출
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun goBackFragment() { parentFragmentManager.popBackStack() }
}