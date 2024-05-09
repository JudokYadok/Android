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
import com.example.nunettine.data.remote.dto.study.StudyListRes
import com.example.nunettine.data.remote.dto.study.TextList
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.StudyListView
import com.example.nunettine.databinding.FragmentChooseBinding
import com.example.nunettine.ui.main.MainActivity

class ChooseFragment: Fragment(), StudyListView {
    private lateinit var binding: FragmentChooseBinding
    private var type = arguments?.getInt("type")
    private var category = arguments?.getString("category")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentChooseBinding.inflate(layoutInflater)
        if(type == 0) {
            setPrevChooseService(category!!)
        } else {
            // setMyTypeService()
        }

        clickListner()
        return binding.root
    }

    private fun initRV(text_list: List<TextList>) = with(binding){
        val chooseRVAdapter = ChooseRVAdapter(text_list, requireContext(), type!!, category!!)
        // RecyclerView 어댑터 설정
        chooseRv.layoutManager = LinearLayoutManager(requireContext())
        // RecyclerView 레이아웃 매니저 설정
        chooseRv.adapter = chooseRVAdapter
    }

    private fun clickListner() = with(binding) {
        chooseBackBtn.setOnClickListener { moveToTypeFragment(type!!) }
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

    private fun moveToTypeFragment(type: Int) {
        val typeFragment = TypeFragment.newInstance(type)
        moveFragment(typeFragment)
    }

    private fun setPrevChooseService(category: String) {
        val setStudyListService = QuizService()
        setStudyListService.getStudyListView(this@ChooseFragment)
        setStudyListService.getPrevTextList(category)
    }

    override fun onGetStudyListSuccess(response: StudyListRes) {
        initRV(response.text_list)
        Log.d("TEXT-LIST-성공", response.toString())
    }

    override fun onGetStudyListFailure(result_code: Int, result_req: String) {
        Log.d("TEXT-LIST-오류", result_req)
    }

    companion object {
        fun newInstance(type: Int, category: String): ChooseFragment {
            val fragment = ChooseFragment()
            val args = Bundle()
            args.putInt("type", type)
            args.putString("category", category)
            fragment.arguments = args
            return fragment
        }
    }
}