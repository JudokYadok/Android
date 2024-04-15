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
import com.example.nunettine.databinding.ItemContentsListBinding
import com.example.nunettine.ui.etc.AlertDialog
import com.example.nunettine.ui.etc.DeleteDialog
import com.example.nunettine.ui.main.MainActivity
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
                //moveFragment(ModifyMemoFragment())
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
        var activity = MainActivity()
        val mainFrmLayout = activity?.findViewById<FrameLayout>(R.id.main_frm)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        mainFrmLayout?.id?.let { transaction?.replace(it, fragment) }
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}