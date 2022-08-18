package kr.edcan.ssf2022.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentMain1Binding
import kr.edcan.ssf2022.ui.write.WriteActivity
import kr.edcan.ssf2022.util.ExtraKey
import java.util.Date

class Main1Fragment : Fragment() {
    lateinit var binding : FragmentMain1Binding
    val viewModel : Main1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main1, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        binding.btnMain1GotoWrite.setOnClickListener {
            val intent = Intent(context, WriteActivity::class.java)
            intent.putExtra(ExtraKey.userData, (activity as MainActivity).viewModel.userData.value)
            activity!!.startActivity(intent)
        }

        binding.txtMain1Calendar.setOnDateChangeListener { v, year, month, day ->
            Log.d("caneldayset", "${year}년 ${month}월 ${day}일")
            viewModel.selectedData.value = Date(year - 1900, month, day)
        }

        return binding.root
    }
}