package kr.edcan.ssf2022.ui.all

import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("input_enabled")
fun input_enabled(v : Button, condition : Boolean) {
    v.isEnabled = condition
}

@BindingAdapter("uri")
fun uri(v : ImageView, image : Uri){
    v.setImageURI(image)
}
