package com.example.nunettine.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemTypeBinding
import com.example.nunettine.ui.main.MainActivity

class TypeRVAdapter(private val categoryList: ArrayList<String>, private val context: Context, private val type: Int): RecyclerView.Adapter<TypeRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemTypeBinding

    inner class ViewHolder(val binding: ItemTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) = with(binding) {
            typeItemTv.text = category

            typeItemLo.setOnClickListener {
                moveToChooseFragment(type, category)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemTypeBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = categoryList.size // 임시 설정

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(categoryList[position])

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

    private fun moveToChooseFragment(type: Int, category: String) {
        val chooseFragment = ChooseFragment.newInstance(type, category)
        moveFragment(chooseFragment)
    }
}