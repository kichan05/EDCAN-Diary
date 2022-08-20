package kr.edcan.ssf2022.ui.all

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

@BindingAdapter("bindVisibility")
fun bindVisibility(view : View, visibility : Boolean){
    view.visibility = if(visibility) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("input_enabled")
fun bindEnabled(v : Button, condition : Boolean) {
    v.isEnabled = condition
}

@BindingAdapter("uri")
fun bindUri(v : ImageView, image : Uri){
    v.setImageURI(image)
}

@BindingAdapter("bindRbCurrentSelect")
fun bindRadioButtonChoice(radioButton: RadioButton, selectedId : Int) {
    radioButton.isChecked = radioButton.id == selectedId
}

@BindingAdapter("bindSrc")
fun bindSrc(imageView: ImageView, url : String){
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}

@BindingAdapter("bindDateFormat")
fun bindDateFormat(textView: TextView, date : Date){
    val simpleDateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
    val strNowDate = simpleDateFormat.format(date)

    textView.text = strNowDate
}

@BindingAdapter("bindToolBarDateFormat")
fun bindToolBarDateFormat(toolBar : androidx.appcompat.widget.Toolbar, date : Date){
    Log.d("bindToolBarDateFormat", date.toString())
    toolBar.title = "${date.year + 1900}년 ${date.month + 1}월 ${date.date - 2}일 일기"
}