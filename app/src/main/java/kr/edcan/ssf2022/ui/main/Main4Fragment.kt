package kr.edcan.ssf2022.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.FragmentMain4Binding
import kr.edcan.ssf2022.ui.login.LoginActivity

class Main4Fragment : Fragment() {
    lateinit var binding : FragmentMain4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main4, container, false)

        binding.btnMain4Logout.setOnClickListener {
            val auth : FirebaseAuth = FirebaseAuth.getInstance()
            auth.signOut()

            val intent = Intent(binding.root.context, LoginActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        }

        return binding.root
    }
}