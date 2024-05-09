package com.example.nunettine.ui.home

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
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.study.StudyDetailRes
import com.example.nunettine.data.remote.service.library_study.QuizService
import com.example.nunettine.data.remote.view.study.StudyDetailView
import com.example.nunettine.databinding.FragmentPreviewContentsBinding
import com.example.nunettine.ui.main.MainActivity

class PreviewContentsFragment: Fragment(), StudyDetailView {
    private lateinit var binding: FragmentPreviewContentsBinding
    private var type = arguments?.getInt("type")
    private var category = arguments?.getString("category")
    private var text_id = arguments?.getInt("text_id")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPreviewContentsBinding.inflate(layoutInflater)
        if(type == 0) {
            setStudyPrevDetailService(category!!, text_id!!)
        } else {
//            setStudyMyDetailService(category, text_id)
        }

        clickListener()
        return binding.root
    }

    private fun clickListener() = with(binding) {
        previewContentsBackBtn.setOnClickListener { moveToBackFragment(type!!, category!!) }
        previewContentsBtn.setOnClickListener { moveToMergeFragment(type!!, text_id!!, category!!) }
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

    private fun moveToBackFragment(type: Int, category: String) {
        val chooseFragment = ChooseFragment.newInstance(type, category)
        moveFragment(chooseFragment)
    }

    private fun moveToMergeFragment(type: Int, text_id: Int, category: String) {
        val mergeCountFragment = MergeCountFragment.newInstance(type, text_id, category)
        moveFragment(mergeCountFragment)
    }

    private fun setStudyPrevDetailService(category: String, text_id: Int) {
        val setStudyDetailService = QuizService()
        setStudyDetailService.getStudyDetailView(this@PreviewContentsFragment)
        setStudyDetailService.getPrevText(category, text_id)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    private fun saveData(text_title: String, text_contents: String) {
        // 데이터 저장
        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("text", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("text_title", text_title)
        editor.putString("text_contents", text_contents)
        editor.apply()
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun onGetStudyDetailSuccess(response: StudyDetailRes) {
        binding.previewContentsTv.text = response.text_title
        binding.previewContentsDetailTv.text = response.text_contents
        saveData(response.text_title, response.text_contents)
        Log.d("TEXT-DETAIL-성공", response.toString())
    }

    override fun onGetStudyDetailFailure(result_code: Int, result_req: String) {
        Log.d("TEXT-DETAIL-오류", result_req)
    }

    companion object {
        fun newInstance(type: Int, text_id: Int, category: String): PreviewContentsFragment {
            val fragment = PreviewContentsFragment()
            val args = Bundle()
            args.putInt("type", type)
            args.putInt("text_id", text_id)
            args.putString("category", category)
            fragment.arguments = args
            return fragment
        }
    }
}