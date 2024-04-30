package com.example.nunettine.ui.save.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentModifyMemoBinding

class ModifyMemoFragment: Fragment() {
    private lateinit var binding: FragmentModifyMemoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentModifyMemoBinding.inflate(layoutInflater)
        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        modifyMemoBackBtn.setOnClickListener {
            goBackFragment()
        }

        modifyMemoBtn.setOnClickListener {
            // 메모 수정 저장
            Toast.makeText(context, "수정되었습니다.", Toast.LENGTH_SHORT).show()
            goBackFragment()
        }
    }

    private fun modifyMemo() {
        // 변경사항이 있는 메모 저장 api 호출
    }

    private fun goBackFragment() { parentFragmentManager.popBackStack() }
}