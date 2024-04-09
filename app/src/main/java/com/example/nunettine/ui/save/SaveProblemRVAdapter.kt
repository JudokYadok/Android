package com.example.nunettine.ui.save

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.databinding.ItemProblemListBinding

class SaveProblemRVAdapter(private val context: Context): RecyclerView.Adapter<SaveProblemRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemProblemListBinding
    inner class ViewHolder(val binding: ItemProblemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}