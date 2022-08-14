package kr.edcan.ssf2022.ui.all

import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.databinding.BindingAdapter


@BindingAdapter("input_enabled")
fun bindEnabled(v : Button, condition : Boolean) {
    v.isEnabled = condition
}

@BindingAdapter("uri")
fun bindUri(v : ImageView, image : Uri){
    v.setImageURI(image)
}

@BindingAdapter(value = ["choiceIndex", "radioButtonIndex"], requireAll = true)
fun bindRadioButtonChoice(radioButton: RadioButton, choiceIndex : Int, radioButtonIndex : Int) {
    radioButton.isChecked = choiceIndex == radioButtonIndex
}
