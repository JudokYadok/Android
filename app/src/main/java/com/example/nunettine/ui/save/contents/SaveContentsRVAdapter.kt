package com.example.nunettine.ui.save.contents

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.library.MemoList
import com.example.nunettine.data.remote.dto.library.TextList
import com.example.nunettine.databinding.ItemContentsListBinding
import com.example.nunettine.ui.main.MainActivity
import com.example.nunettine.ui.save.memo.ModifyMemoFragment

class SaveContentsRVAdapter(private val context: Context, private val contentsList: MutableList<TextList>): RecyclerView.Adapter<SaveContentsRVAdapter.ViewHolder>() {
    private lateinit var binding : ItemContentsListBinding
    inner class ViewHolder(val binding: ItemContentsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {

            itemContentsListDelBtn.setOnClickListener {
            }

            itemContentsListLo.setOnClickListener {
                moveFragment(ModifyContentsFragment())
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemContentsListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 1 // 임시 설정

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

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
}