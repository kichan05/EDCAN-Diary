package kr.edcan.ssf2022.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.builder.TedImagePicker
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentRegister3Binding
import kr.edcan.ssf2022.ui.main.MainActivity

class Register3Fragment : Fragment() {
    lateinit var binding: FragmentRegister3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register3, container, false)

        binding.run {

            btnRegister3Next.setOnClickListener {
                (activity as RegisterActivity).run {
                    inputMessage = edtRegister3MessageInput.text.toString()
                    register()
                }
            }

            imgRegister3Profile.setOnClickListener {
                inputProfileImage()
            }

            btnRegister4GetImage.setOnClickListener {
                inputProfileImage()
            }
        }


        return binding.root
    }

    private fun inputProfileImage() {
        TedImagePicker.with(context!!)
            .start { uri ->
                (activity as RegisterActivity).inputProfileImage = uri
                Glide.with(context!!)
                    .load(uri)
                    .into(binding.imgRegister3Profile)
            }
    }
}