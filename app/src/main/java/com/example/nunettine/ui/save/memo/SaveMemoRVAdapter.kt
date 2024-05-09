package com.example.nunettine.ui.save.memo

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nunettine.R
import com.example.nunettine.data.remote.dto.library.MemoList
import com.example.nunettine.databinding.ItemMemoListBinding
import com.example.nunettine.ui.etc.DeleteDialog
import com.example.nunettine.ui.main.MainActivity

class SaveMemoRVAdapter(private val context: Context, private val fragmentManager: FragmentManager, private val memoList: List<MemoList>): RecyclerView.Adapter<SaveMemoRVAdapter.ViewHolder>() {
    private lateinit var binding :ItemMemoListBinding
    inner class ViewHolder(val binding: ItemMemoListBinding): RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
        fun bind(memo_list: MemoList) = with(binding) {
            itemMemoListNameTv.text = memo_list.title

            itemMemoListDelBtn.setOnClickListener {
                val dialog = context?.let { fragmentManager?.let { it1 -> DeleteDialog(it, it1) } }
                if (dialog != null) {
                    dialog.show()
                }
            }

            itemMemoListLo.setOnClickListener {
                moveFragment(ModifyMemoFragment())
                saveData(memo_list.memo_id)
                Log.d("MEMO-ID", memo_list.memo_id.toString())
            }

            itemMemoListDateTv.text = memo_list.updatedAt
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMemoListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = memoList.size // 임시 설

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(memoList[position])

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

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    private fun saveData(memoId: Int) {
        // 데이터 저장
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("memo", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("memo_id", memoId)
        editor.apply()
    }
}