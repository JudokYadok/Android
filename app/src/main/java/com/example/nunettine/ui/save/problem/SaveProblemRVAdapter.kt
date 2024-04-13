package com.example.nunettine.ui.save.problem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemMemoListBinding
import com.example.nunettine.databinding.ItemProblemListBinding
import com.example.nunettine.ui.etc.AlertDialog
import com.example.nunettine.ui.etc.DeleteDialog
import com.example.nunettine.ui.save.memo.ModifyMemoFragment

class SaveProblemRVAdapter(private val context: Context, private var fragmentManager: FragmentManager): RecyclerView.Adapter<SaveProblemRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemProblemListBinding
    inner class ViewHolder(val binding: ItemProblemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            itemProblemListDelBtn.setOnClickListener {
                val dialog = context?.let { fragmentManager?.let { it1 -> DeleteDialog(it, it1) } }
                if (dialog != null) {
                    dialog.show()
                }
            }

            itemProblemListLo.setOnClickListener {
                moveFragment(ModifyMemoFragment())
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SaveProblemRVAdapter.ViewHolder {
        binding = ItemProblemListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = 1 // 임시 설정

    override fun onBindViewHolder(holder: SaveProblemRVAdapter.ViewHolder, position: Int) = holder.bind()

    private fun moveFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}