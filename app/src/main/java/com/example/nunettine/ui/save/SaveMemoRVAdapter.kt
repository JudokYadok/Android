package com.example.nunettine.ui.save

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemMemoListBinding
import com.example.nunettine.ui.etc.AlertDialog

class SaveMemoRVAdapter(private val context: Context, private var fragmentManager: FragmentManager): RecyclerView.Adapter<SaveMemoRVAdapter.ViewHolder>() {
    private lateinit var binding :ItemMemoListBinding
    inner class ViewHolder(val binding: ItemMemoListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            itemMemoListDelBtn.setOnClickListener {
                val dialog = context?.let { fragmentManager?.let { it1 -> AlertDialog(it, it1) } }
                if (dialog != null) {
                    dialog.show()
                }
            }

            itemMemoListLo.setOnClickListener {
                moveFragment(ModifyMemoFragment())
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SaveMemoRVAdapter.ViewHolder {
        binding = ItemMemoListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SaveMemoRVAdapter.ViewHolder, position: Int) = holder.bind()

    private fun moveFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}