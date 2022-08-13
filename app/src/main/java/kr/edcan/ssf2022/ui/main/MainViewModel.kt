package kr.edcan.ssf2022.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.edcan.ssf2022.model.data.Diary
import kr.edcan.ssf2022.model.data.User
import kr.edcan.ssf2022.model.remote.AuthRepositoryImpl
import kr.edcan.ssf2022.model.remote.DiaryRepository
import kr.edcan.ssf2022.model.remote.DiaryRepositoryImpl
import kr.edcan.ssf2022.util.Result
import kr.edcan.ssf2022.util.State
import java.util.*

class MainViewModel : ViewModel() {
    val userData: MutableLiveData<User> = MutableLiveData()

    val diaryData : MutableLiveData<Diary> = MutableLiveData<Diary>(
        Diary(date = Date(), weather = 2, emotion = 4, content = "대충 일기")
    )
    val diaryList : MutableLiveData<List<Diary>> = MutableLiveData()
    fun test() {
        viewModelScope.launch {
//            val diaryList = diaryRepository.getDiaryAll(userData.value!!)
//            this@MainViewModel.diaryList.value = diaryList
        }
    }
}