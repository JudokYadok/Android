package com.example.nunettine.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nunettine.CircleTransform
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentHomeBinding
import com.example.nunettine.ui.home.viewmodel.HomeViewModel
import com.squareup.picasso.Picasso

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        var spf = requireContext().getSharedPreferences("kakao", AppCompatActivity.MODE_PRIVATE)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        homeViewModel.profileML.observe(viewLifecycleOwner, Observer {
            homeViewModel.profileML.postValue(spf.getString("profile", ""))
            Picasso.get().load(homeViewModel.profileML.value).transform(CircleTransform()).into(binding.homeProfileIv)
        })

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        home1Btn.setOnClickListener {
            moveFragment(TypeFragment())
        }

        home2Btn.setOnClickListener {
            moveFragment(TypeFragment())
        }
    }
    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }
}