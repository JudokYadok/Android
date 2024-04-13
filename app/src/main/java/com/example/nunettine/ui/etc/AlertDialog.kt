package com.example.nunettine.ui.etc

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.nunettine.R
import com.example.nunettine.databinding.DialogAlertBinding
import com.example.nunettine.ui.save.memo.SaveMemoFragment

class AlertDialog(private var context: Context, private val fragmentManager: FragmentManager): Dialog(context) {
    private lateinit var binding: DialogAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogAlertBinding.inflate(layoutInflater)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binding.root)
        setCanceledOnTouchOutside(true) // 다이얼로그 바깥을 터치하면 닫힘
        clickListener()
    }

    private fun clickListener() = with(binding) {
        dialogAlertYesBtn.setOnClickListener {
            Toast.makeText(context, "작성이 취소되었습니다.", Toast.LENGTH_SHORT).show()
            super.onBackPressed()
        }
        dialogAlertNoBtn.setOnClickListener { dismiss() }
    }

    private fun moveFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}