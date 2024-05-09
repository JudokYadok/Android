package com.example.nunettine.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.StudyCategoryRes
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.StudyCategoryView
import com.example.nunettine.databinding.FragmentTypeBinding
import com.example.nunettine.ui.main.MainActivity

class TypeFragment: Fragment(), StudyCategoryView {
    private lateinit var binding: FragmentTypeBinding
    private var type = arguments?.getInt("type")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTypeBinding.inflate(layoutInflater)
        if(type == 0) {
            setPrevTypeService()
        } else {
            // setMyTypeService()
        }

        clickListener()
        return binding.root
    }

    private fun initRV(categoryList: ArrayList<String>) = with(binding){
        val typeRVAdapter = TypeRVAdapter(categoryList, requireContext(), type!!)
        // RecyclerView 어댑터 설정
        typeRv.layoutManager = LinearLayoutManager(requireContext())
        // RecyclerView 레이아웃 매니저 설정
        typeRv.adapter = typeRVAdapter
    }

    private fun clickListener() = with(binding) {
        typeBackBtn.setOnClickListener { moveFragment(HomeFragment()) }
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

    private fun setPrevTypeService() {
        val setStudyCategoryService = QuizService()
        setStudyCategoryService.getStudyCategoryView(this@TypeFragment)
        setStudyCategoryService.getPrevTextCategory()
    }

    override fun onGetStudyCategorySuccess(response: StudyCategoryRes) {
        initRV(response.category_list)
        Log.d("TYPE-성공", response.toString())
    }

    override fun onGetStudyCategoryFailure(result_code: Int, result_req: String) {
        Log.d("TYPE-오류", result_req)
    }

    companion object {
        fun newInstance(type: Int): TypeFragment {
            val fragment = TypeFragment()
            val args = Bundle()
            args.putInt("type", type) // 데이터를 담습니다.
            fragment.arguments = args
            return fragment
        }
    }
}