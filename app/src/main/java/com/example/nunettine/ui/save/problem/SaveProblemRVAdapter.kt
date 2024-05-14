package com.example.nunettine.ui.save.problem

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.databinding.ItemProblemListBinding
import com.example.nunettine.ui.main.MainActivity
import com.example.nunettine.ui.save.memo.ModifyMemoFragment

class SaveProblemRVAdapter(private val context: Context, private var fragmentManager: FragmentManager): RecyclerView.Adapter<SaveProblemRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemProblemListBinding
    inner class ViewHolder(val binding: ItemProblemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            itemProblemListDelBtn.setOnClickListener {
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