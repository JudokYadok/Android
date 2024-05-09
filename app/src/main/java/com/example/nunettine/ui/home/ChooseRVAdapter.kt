package com.example.nunettine.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.TextList
import com.example.nunettine.databinding.ItemChooseBinding
import com.example.nunettine.ui.main.MainActivity

class ChooseRVAdapter(private val textList: List<TextList>, private val context: Context, private val type: Int, private val category: String): RecyclerView.Adapter<ChooseRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemChooseBinding
    inner class ViewHolder(val binding: ItemChooseBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(text_list: TextList) = with(binding) {
            chooseItemTv.text = text_list.title
            chooseItemLo.setOnClickListener {
                moveToDetailFragment(type, text_list.text_id, category)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemChooseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = textList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(textList[position])

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

    private fun moveToDetailFragment(type: Int, text_id: Int, category: String) {
        val previewContentsFragment = PreviewContentsFragment.newInstance(type, text_id, category)
        moveFragment(previewContentsFragment)
    }
}