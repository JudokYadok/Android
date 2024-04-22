package com.example.nunettine.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemChooseBinding
import com.example.nunettine.ui.main.MainActivity

class ChooseRVAdapter(private val context: Context, private var fragmentManager: FragmentManager): RecyclerView.Adapter<ChooseRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemChooseBinding
    inner class ViewHolder(val binding: ItemChooseBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            chooseItemLo.setOnClickListener {
                //moveFragment()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemChooseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
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