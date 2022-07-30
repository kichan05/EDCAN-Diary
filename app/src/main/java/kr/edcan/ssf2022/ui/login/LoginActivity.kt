package kr.edcan.ssf2022.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.ActivityLoginBinding
import kr.edcan.ssf2022.ui.main.MainActivity
import kr.edcan.ssf2022.ui.register.RegisterActivity
import kr.edcan.ssf2022.util.State

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val viewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        with(binding) {
            btnLoginRegister.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }

            btnLoginLogin.setOnClickListener {
                viewModel.login()
            }
        }

        viewModel.state.observe(this){
            when(it){
                State.SUCCESS -> {
                    Toast.makeText(this, "로그인에 성공하셨습니다", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                State.LOADING -> {
                    Toast.makeText(this, "로그인 진행중", Toast.LENGTH_LONG).show()
                }
                State.FAIL -> {
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}