package com.example.nunettine.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.nunettine.R
import com.example.nunettine.databinding.FragmentPreviewContentsBinding
import com.example.nunettine.ui.main.MainActivity

class PreviewContentsFragment: Fragment() {
    private lateinit var binding: FragmentPreviewContentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPreviewContentsBinding.inflate(layoutInflater)

        clickListener()

        // 임시 설정
        binding.previewContentsEt.setText(" 사람은 살아가는 동안 여러 약속을 한다. 계약도 하나의 약속 이다. 하지만 이것은 친구와 뜻이 맞아 주말에 영화 보러 가자는 약속과는 다르다. 일반적인 다른 약속처럼 계약도 서로의 의사 표시가 합치하여 성립하지만, 이때의 의사는 일정한 법률 효과의 발생을 목적으로 한다는 점에서 차이가 있다. 한 예로 매매 계약 은 ‘팔겠다’는 일방의 의사 표시와 ‘사겠다’는 상대방의 의사 표시가 합치함으로써 성립하며, 매도인은 매수인에게 매매 목적물 의 소유권을 이전하여야 할 의무를 짐과 동시에 매매 대금의 지급을 청구할 권리를 갖는다. 반대로 매수인은 매도인에게 매매 대금을 지급할 의무가 있고 소유권의 이전을 청구할 권리를 갖는다. 양 당사자는 서로 권리를 행사하고 서로 의무를 이행 하는 관계에 놓이는 것이다. \n" +
                " 이처럼 의사 표시를 필수적 요소로 하여 법률 효과를 발생시 키는 행위들을 법률 행위라 한다. 계약은 법률 행위의 일종으 로서, 당사자에게 일정한 청구권과 이행 의무를 발생시킨다. 청구권을 내용으로 하는 권리가 채권이고, 그에 따라 이행을 해야 할 의무가 채무이다. 따라서 채권과 채무는 발생한 법률 효과가 동전의 양면처럼 서로 다른 방향에서 파악되는 것이라 할 수 있다. 채무자가 채무의 내용대로 이행하여 채권을 소멸시 키는 것을 변제라 한다. \n" +
                " 갑과 을은 을이 소유한 그림 A를 갑에게 매도하는 것을 내용 으로 하는 매매 계약을 체결하였다. ㉠ 을의 채무는 그림 A의 소유권을 갑에게 이전하는 것이다. 동산인 물건의 소유권을 이전 하는 방식은 그 물건을 인도하는 것이다. 갑은 그림 A가 너무나 마음에 들었기 때문에 그것을 인도받기 전에 대금 전액을 금전 으로 지급하였다. 그런데 갑이 아무리 그림 A를 넘겨달라고 청구 하여도 을은 인도해 주지 않았다. 이런 경우 갑이 사적으로 물리력 을 행사하여 해결하는 것은 엄격히 금지된다. \n" +
                " 채권의 내용은 민법과 같은 실체법에서 규정하고 있고, 그것 을 강제적으로 실현할 수 있도록 민사 소송법이나 민사 집행법 같은 절차법이 갖추어져 있다. ")

        return binding.root
    }

    private fun clickListener() = with(binding) {
        previewContentsBackBtn.setOnClickListener { goBackFragment() }
        previewContentsBtn.setOnClickListener { moveFragment(MergeCountFragment()) }
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