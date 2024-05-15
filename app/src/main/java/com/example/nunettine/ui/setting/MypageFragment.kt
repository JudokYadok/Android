package com.example.nunettine.ui.setting

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nunettine.R
import com.example.nunettine.data.local.UserReq
import com.example.nunettine.databinding.FragmentSettingMypageBinding
import com.example.nunettine.ui.etc.DdayDialog
import com.example.nunettine.ui.main.MainActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Locale

class MypageFragment: Fragment() {
    private lateinit var binding: FragmentSettingMypageBinding
    private lateinit var viewModel: MyPageViewModel
    private var user_id: Int = 0
    var daysUntilDDay = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingMypageBinding.inflate(layoutInflater)
        getData()
        viewModel = ViewModelProvider(this).get(MyPageViewModel::class.java)
        viewModel.getUserInfoService(user_id)
        initUI(viewModel.emailML.value!!, viewModel.nameML.value!!, viewModel.joinDateML.value!!)
        observeUserInfo()
        writeDday()
        Log.d("day", "${viewModel.dDayYearML.value}, ${viewModel.dDayMonthML.value}, ${viewModel.dDayDateML.value}")
        val dDay = LocalDate.of(viewModel.dDayYearML.value!!, viewModel.dDayMonthML.value!!, viewModel.dDayDateML.value!!)
        val today = LocalDate.now()
        daysUntilDDay = ChronoUnit.DAYS.between(today, dDay)
        Log.d("DAY", "${daysUntilDDay}")
        clickListener()

        return binding.root
    }

    private fun clickListener() = with(binding) {
        mypageBackBtn.setOnClickListener { moveFragment(SettingFragment()) }
        mypageModifyBtn.setOnClickListener {
            val userReq = UserReq(mypageNicknameEt.text.toString(), mypageEmailEt.text.toString(), mypageCalendarEt.text.toString().toInt(), user_id)
            viewModel.putUserInfoService(userReq)
        }
        mypageDeleteBtn.setOnClickListener { viewModel.deleteUserInfoService(user_id) }
        mypageCalendarLo.setOnClickListener {
            mypageCalendarAddLo.visibility = View.VISIBLE

        }
    }

    private fun writeDday() = with(binding) {
        // d-day 날짜 기본 설정
        mypageCalendarAddYearEt.setText(viewModel.dDayYearML.value!!)
        mypageCalendarAddMonthEt.setText(viewModel.dDayMonthML.value!!)
        mypageCalendarAddDateEt.setText(viewModel.dDayDateML.value!!)

        viewModel.dDayYearML.value = mypageCalendarAddYearEt.text.toString().toInt()
        viewModel.dDayMonthML.value = mypageCalendarAddMonthEt.text.toString().toInt()
        viewModel.dDayDateML.value = mypageCalendarAddDateEt.text.toString().toInt()
        observeUserInfo()
    }

    fun moveFragment(fragment: Fragment) {
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

    private fun initUI(email: String, name: String, join: String) = with(binding) {
        mypageNicknameEt.setText(name)
        mypageEmailEt.setText(email)
        mypageJoinTv.text = join
    }

    private fun initDday() = with(binding) {
        mypageCalendarEt.text = daysUntilDDay.toString()
    }

    private fun timeFormat(originalTime: String): String {
        // 원본 문자열을 날짜로 파싱합니다.
        val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val originalDate = originalFormat.parse(originalTime)

        // 포맷을 변경하고자 하는 형식을 정의합니다.
        val targetFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

        // 새로운 형식으로 포맷합니다.
        val formattedDate = targetFormat.format(originalDate)
        return formattedDate
    }

    private fun getData() {
        // 데이터 읽어오기
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("kakao", Context.MODE_PRIVATE)
        user_id = sharedPreferences.getInt("user_id", user_id)!!
    }

    private fun observeUserInfo() {
        viewModel.emailML.observe(viewLifecycleOwner) { email ->
            viewModel.nameML.observe(viewLifecycleOwner) { name ->
                viewModel.joinDateML.observe(viewLifecycleOwner) { join ->
                    // 데이터가 변경되었을 때 UI 업데이트
                    initUI(email, name, join)
                }
            }
        }

        viewModel.dDayYearML.observe(viewLifecycleOwner) { year ->
            viewModel.dDayMonthML.observe(viewLifecycleOwner) { month ->
                viewModel.dDayDateML.observe(viewLifecycleOwner) { date ->
                    initDday()
                }
            }
        }
    }
}