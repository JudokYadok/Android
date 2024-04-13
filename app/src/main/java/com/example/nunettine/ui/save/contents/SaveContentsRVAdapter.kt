package com.example.nunettine.ui.save.contents

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemContentsListBinding
import com.example.nunettine.ui.etc.AlertDialog
import com.example.nunettine.ui.etc.DeleteDialog
import com.example.nunettine.ui.save.memo.ModifyMemoFragment

class SaveContentsRVAdapter(private val context: Context, private var fragmentManager: FragmentManager): RecyclerView.Adapter<SaveContentsRVAdapter.ViewHolder>() {
    private lateinit var binding : ItemContentsListBinding
    inner class ViewHolder(val binding: ItemContentsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            itemContentsListDelBtn.setOnClickListener {
                val dialog = context?.let { fragmentManager?.let { it1 -> DeleteDialog(it, it1) } }
                if (dialog != null) {
                    dialog.show()
                }
            }

            itemContentsListLo.setOnClickListener {
                moveFragment(ModifyMemoFragment())
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
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}