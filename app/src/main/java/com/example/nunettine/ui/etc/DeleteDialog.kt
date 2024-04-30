package com.example.nunettine.ui.etc

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.nunettine.databinding.DialogDeleteBinding

class DeleteDialog(private var context: Context, private var fragmentManager: FragmentManager): Dialog(context) {
    private lateinit var binding: DialogDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogDeleteBinding.inflate(layoutInflater)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binding.root)
        setCanceledOnTouchOutside(true) // 다이얼로그 바깥을 터치하면 닫힘
        clickListener()
    }

    private fun clickListener() = with(binding) {
        dialogDeleteYesBtn.setOnClickListener {
            Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        dialogDeleteNoBtn.setOnClickListener { dismiss() }
    }
}