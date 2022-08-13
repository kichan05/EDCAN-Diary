package kr.edcan.ssf2022.ui.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentRegister2Binding

class Register2Fragment : Fragment() {
    lateinit var binding: FragmentRegister2Binding
    val viewModel: Register2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register2, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner

        binding.run {
            btnRegister2Next.setOnClickListener {

                if(viewModel.password.value != viewModel.passwordRe.value) {
                    Snackbar.make(it, "비밀번호가 서로 달라요", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                (activity as RegisterActivity).run {
                    inputPassword = this@Register2Fragment.viewModel.password.value!!

                    navController.navigate(R.id.action_register2Fragment_to_register3Fragment)
                }
            }
        }

        viewModel.password.observe(viewLifecycleOwner){
            viewModel.checkNext()
        }

        viewModel.passwordRe.observe(viewLifecycleOwner){
            viewModel.checkNext()
        }


        return binding.root
    }
}