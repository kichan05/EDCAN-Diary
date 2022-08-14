package kr.edcan.ssf2022.ui.write

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.edcan.ssf2022.model.data.Diary
import kr.edcan.ssf2022.model.data.User
import kr.edcan.ssf2022.model.remote.DiaryRepositoryImpl
import kr.edcan.ssf2022.util.Result
import kr.edcan.ssf2022.util.State
import java.util.*

class WriteViewModel : ViewModel() {
    private val diaryRepository = DiaryRepositoryImpl()

    val userData = MutableLiveData<User>()

    val weather = MutableLiveData<Int>(0)
    val emotion = MutableLiveData<Int>(0)
    val content = MutableLiveData<String>()

    val state = MutableLiveData<Int>()

    fun writeDiary() {
        val diaryData = Diary(
            date = Date(),
            weather = weather.value!!,
            emotion = emotion.value!!,
            content = content.value!!
        )

        state.value = State.LOADING

        viewModelScope.launch {
            val writeDiaryResult = diaryRepository.writeDiary(diaryData, userData.value!!)

            when (writeDiaryResult) {
                Result.SUCCESS -> {
                    state.value = State.SUCCESS
                }
                Result.FAILED ->{
                    state.value = State.FAIL
                }
            }
        }
    }
}