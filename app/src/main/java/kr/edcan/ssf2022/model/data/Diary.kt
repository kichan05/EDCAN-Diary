package kr.edcan.ssf2022.model.data

import java.util.*


data class Diary(
    val date: Date = Date(),
    val weather : Int = 0,
    val emotion : Int = 0,
    val content : String = "",
)
