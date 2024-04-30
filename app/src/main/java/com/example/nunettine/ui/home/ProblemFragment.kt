package com.example.nunettine.ui.home

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentProblemBinding
import com.example.nunettine.ui.main.MainActivity

class ProblemFragment : Fragment() {
    private lateinit var binding: FragmentProblemBinding
    private var isPlaying = false
    private var pauseTime = 0L // 멈춤 시간

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProblemBinding.inflate(layoutInflater)
        clickListener()
        settingMedia()
        return binding.root
    }

    private fun settingMedia() = with(binding) {
        problemPlayBtn.setOnClickListener {
            Log.d("MEDIA-PLAY", problemMediaTv.text.toString())

            // 정지 상태일 때만 실행
            if(!isPlaying) {
                startChronometer()
            }
        }

        problemTempoBtn.setOnClickListener {
            Log.d("MEDIA-PAUSE", problemMediaTv.text.toString())

            // 실행 상태일 때만 실행
            if(isPlaying) {
                pauseChronometer()
            }
        }

        problemStopBtn.setOnClickListener {
            Log.d("MEDIA-STOP", problemMediaTv.text.toString())

            stopChronometer()
        }
    }

    private fun startChronometer() = with(binding) {
        problemMediaTv.base = SystemClock.elapsedRealtime() - pauseTime
        problemMediaTv.start()
        problemPlayBtn.visibility = View.GONE
        problemTempoBtn.visibility = View.VISIBLE
        isPlaying = true
    }

    private fun stopChronometer() = with(binding) {
        problemMediaTv.base = SystemClock.elapsedRealtime()
        pauseTime = 0L
        problemMediaTv.stop()
        problemPlayBtn.visibility = View.VISIBLE
        problemTempoBtn.visibility = View.GONE
        isPlaying = false
    }

    private fun pauseChronometer() = with(binding) {
        problemMediaTv.stop()
        pauseTime = SystemClock.elapsedRealtime() - problemMediaTv.base
        problemPlayBtn.visibility = View.VISIBLE
        problemTempoBtn.visibility = View.GONE
        isPlaying = false
    }

    private fun clickListener() = with(binding) {
        problemBackBtn.setOnClickListener {
            moveFragment(MergeCountFragment())
            stopChronometer()
        }

        problemMemoBtn.setOnClickListener {
            moveFragment(MemoFragment())
            pauseChronometer()
        }

        problemOmr11btn.setOnClickListener { clickButton1(problemOmr11btn) }
        problemOmr12btn.setOnClickListener { clickButton1(problemOmr12btn) }
        problemOmr13btn.setOnClickListener { clickButton1(problemOmr13btn) }
        problemOmr14btn.setOnClickListener { clickButton1(problemOmr14btn) }
        problemOmr15btn.setOnClickListener { clickButton1(problemOmr15btn) }

        problemOmr21btn.setOnClickListener { clickButton2(problemOmr21btn) }
        problemOmr22btn.setOnClickListener { clickButton2(problemOmr22btn) }
        problemOmr23btn.setOnClickListener { clickButton2(problemOmr23btn) }
        problemOmr24btn.setOnClickListener { clickButton2(problemOmr24btn) }
        problemOmr25btn.setOnClickListener { clickButton2(problemOmr25btn) }

        problemOmr31btn.setOnClickListener { clickButton3(problemOmr31btn) }
        problemOmr32btn.setOnClickListener { clickButton3(problemOmr32btn) }
        problemOmr33btn.setOnClickListener { clickButton3(problemOmr33btn) }
        problemOmr34btn.setOnClickListener { clickButton3(problemOmr34btn) }
        problemOmr35btn.setOnClickListener { clickButton3(problemOmr35btn) }

        problemOmr41btn.setOnClickListener { clickButton4(problemOmr41btn) }
        problemOmr42btn.setOnClickListener { clickButton4(problemOmr42btn) }
        problemOmr43btn.setOnClickListener { clickButton4(problemOmr43btn) }
        problemOmr44btn.setOnClickListener { clickButton4(problemOmr44btn) }
        problemOmr45btn.setOnClickListener { clickButton4(problemOmr45btn) }
    }

    private fun clickButton1(clickedButton: Button) = with(binding) {
        val button1 = listOf(
            problemOmr11btn,
            problemOmr12btn,
            problemOmr13btn,
            problemOmr14btn,
            problemOmr15btn
        )

        button1.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
    }

    private fun clickButton2(clickedButton: Button) = with(binding) {
        val button2 = listOf(
            problemOmr21btn,
            problemOmr22btn,
            problemOmr23btn,
            problemOmr24btn,
            problemOmr25btn
        )

        button2.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
    }

    private fun clickButton3(clickedButton: Button) = with(binding) {
        val button3 = listOf(
            problemOmr31btn,
            problemOmr32btn,
            problemOmr33btn,
            problemOmr34btn,
            problemOmr35btn
        )

        button3.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
    }

    private fun clickButton4(clickedButton: Button) = with(binding) {
        val button4 = listOf(
            problemOmr41btn,
            problemOmr42btn,
            problemOmr43btn,
            problemOmr44btn,
            problemOmr45btn
        )

        button4.forEach { button ->
            button.isSelected = (button == clickedButton)
        }
    }

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

    private fun goBackFragment() {
        parentFragmentManager.popBackStack()
    }
}