package kr.edcan.ssf2022.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentRegister2Binding

class Register2Fragment : Fragment() {
    lateinit var binding : FragmentRegister2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register2, container, false)

        binding.btnRegister2Next.setOnClickListener {
            (activity as RegisterActivity).navController.navigate(R.id.action_register2Fragment_to_register3Fragment)

            Toast.makeText(context, "클릭2", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}