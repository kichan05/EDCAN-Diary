package kr.edcan.ssf2022.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentRegister2Binding

class Register2Fragment : Fragment() {
    lateinit var binding: FragmentRegister2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register2, container, false)

        binding.run {
            btnRegister2Next.setOnClickListener {

                if(edtRegister2Password.text.toString() != edtRegister2PasswordCheck.text.toString()) {
                    Snackbar.make(it, "비밀번호가 서로 달라요", Snackbar.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                (activity as RegisterActivity).run {
                    inputPassword = binding.edtRegister2Password.text.toString()

                    navController.navigate(R.id.action_register2Fragment_to_register3Fragment)
                }
            }
        }


        return binding.root
    }
}