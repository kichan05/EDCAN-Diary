package kr.edcan.ssf2022.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.edcan.ssf2022.model.remote.AuthRepositoryImpl
import kr.edcan.ssf2022.util.State

class LoginViewModel : ViewModel() {
    val auth = AuthRepositoryImpl()

    val state = MutableLiveData<Int>()
    val inputEmail = MutableLiveData<String>()
    val inputPassword = MutableLiveData<String>()

    fun login() {
        state.value = State.LOADING
        viewModelScope.launch {
            val result = auth.login(inputEmail.value!!, inputPassword.value!!)

            if (result != null) {
                //로그인에 성공 한 경우
                state.value = State.SUCCESS
            } else {
                //로그인에 실패한 경우

                state.value = State.FAIL
            }
        }
    }
}