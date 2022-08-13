package kr.edcan.ssf2022.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentMain1Binding
import kr.edcan.ssf2022.ui.write.WriteActivity
import kr.edcan.ssf2022.util.ExtraKey
import kr.edcan.ssf2022.util.ExtraKey.userData

class Main1Fragment : Fragment() {
    lateinit var binding : FragmentMain1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main1, container, false)

        binding.btnMain1GotoWrite.setOnClickListener {
            val intent = Intent(context, WriteActivity::class.java)
            intent.putExtra(ExtraKey.userData, (activity as MainActivity).viewModel.userData.value)
            activity!!.startActivity(intent)
        }

        return binding.root
    }
}