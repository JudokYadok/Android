package com.example.nunettine.ui.save

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentProblemListBinding

class SaveProblemFragment: Fragment() {
    private lateinit var binding: FragmentProblemListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProblemListBinding.inflate(layoutInflater)
        return binding.root
    }

//    private fun initRV() {
//        Log.d("calendarViewModel._categoryList.value",calendarViewModel._categoryList.value.toString())
//        if (!calendarViewModel._categoryList.value.isNullOrEmpty()) {
//            val adapter = MestroySettingRVAdapter(calendarViewModel._categoryList.value!!, requireContext(), this)
//            binding.manageMestoryListRv.adapter = adapter
//            binding.manageMestoryListRv.layoutManager =
//                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        }
//    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}