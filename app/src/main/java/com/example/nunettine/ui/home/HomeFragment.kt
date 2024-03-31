package com.example.nunettine.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentHomeBinding
import com.example.nunettine.ui.home.banner.HomeVP1Fragment
import com.example.nunettine.ui.home.banner.HomeVP2Fragment
import com.example.nunettine.ui.home.banner.HomeVP3Fragment
import com.example.nunettine.ui.home.banner.HomeVPAdapter

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPager: ViewPager2
    private var currentPosition = 0
    val handler = Handler(Looper.getMainLooper()) {
        setPage()
        true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        clickListener()
        bannerInit()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        home1Btn.setOnClickListener {
            moveFragment(TypeFragment())
        }

        home3Btn.setOnClickListener {
            moveFragment(TypeFragment())
        }

        home2Btn.setOnClickListener {

        }
    }

    private fun bannerInit() {
        viewPager = binding.homeBannerVp

        var bannerAdapter = HomeVPAdapter(this@HomeFragment)
        bannerAdapter.addFragment(HomeVP1Fragment())
        bannerAdapter.addFragment(HomeVP2Fragment())
        bannerAdapter.addFragment(HomeVP3Fragment())
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val thread = Thread(PageRunnable())
        thread.start()
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            .replace(R.id.main_frm, fragment)
            .commitAllowingStateLoss()
    }

    private fun setPage() {
        if (currentPosition == 3) currentPosition = 0
        binding.homeBannerVp.setCurrentItem(currentPosition, true)
        currentPosition += 1
    }

    inner class PageRunnable : Runnable {
        override fun run() {
            while (true) {
                Thread.sleep(3000)
                handler.sendEmptyMessage(0)
            }
        }
    }
}