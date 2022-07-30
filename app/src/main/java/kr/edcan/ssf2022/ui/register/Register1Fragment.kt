package kr.edcan.ssf2022.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.NonDisposableHandle.parent
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentRegister1Binding

class Register1Fragment : Fragment() {
    lateinit var binding: FragmentRegister1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register1, container, false)

        binding.run {
            btnRegister1Next.setOnClickListener { // 회원가입 1에서 다음 버튼을 눌렀을때
                (activity as RegisterActivity).run {
                    inputEmail = edtRegister1EmailInput.text.toString()
                    inputName = edtRegister1NameInput.text.toString()

                    navController.navigate(R.id.action_register1Fragment_to_register2Fragment)
                }
            }
        }

        return binding.root
    }
}