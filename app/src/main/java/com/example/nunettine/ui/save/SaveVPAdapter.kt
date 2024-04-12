package com.example.nunettine.ui.save

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nunettine.ui.home.ChooseFragment

class SaveVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int):Fragment {
        return when(position) { // 임시 설정
            0 -> SaveProblemFragment()
            1 -> SaveMemoFragment()
            else -> ChooseFragment()
        }
    }
}