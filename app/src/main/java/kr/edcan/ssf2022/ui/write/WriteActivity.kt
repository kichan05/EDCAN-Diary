package kr.edcan.ssf2022.ui.write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.databinding.ActivityWriteBinding
import kr.edcan.ssf2022.model.data.User
import kr.edcan.ssf2022.util.ExtraKey
import kr.edcan.ssf2022.util.State

class WriteActivity : AppCompatActivity() {
    lateinit var binding : ActivityWriteBinding
    val viewModel : WriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        viewModel.userData.value = intent.getParcelableExtra(ExtraKey.userData)!!

        viewModel.state.observe(this){
            when(it){
                State.SUCCESS -> {
                    Toast.makeText(this, "일기를 작성을 했어요", Toast.LENGTH_SHORT).show()
                    finish()
                }
                State.LOADING -> {

                }
                State.FAIL -> {
                    Toast.makeText(this, "일기를 작성을 실패 했어요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnWriteSave.setOnClickListener {
            viewModel.writeDiary()
        }
    }
}