package kr.edcan.ssf2022.ui.diaryDetail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import kr.edcan.ssf2022.R
import kr.edcan.ssf2022.util.Emotion
import kr.edcan.ssf2022.util.Weather

@BindingAdapter("bindWeatherIconId")
fun weatherIconId(imageview: ImageView, weatherId: Int) {
    val iconId = when(weatherId){
        Weather.sun -> R.drawable.ic_sun_ac
        Weather.cloud -> R.drawable.ic_cloud_ac
        Weather.rain -> R.drawable.ic_rain_ac
        Weather.sunRain -> R.drawable.ic_sun_rain_ac
        Weather.wind -> R.drawable.ic_wind_ac
        Weather.snow -> R.drawable.ic_snow_ac
        else -> R.drawable.ic_sun_ac
    }
    imageview.setImageResource(iconId)
}

@BindingAdapter("bindEmotionIconId")
fun bindEmotionIconId(imageview: ImageView, emotionId : Int){
    val iconId = when(emotionId){
        Emotion.happy -> R.drawable.ic_angry_ac
        Emotion.fun_ -> R.drawable.ic_angry_ac
        Emotion.wow -> R.drawable.ic_angry_ac
        Emotion.normal -> R.drawable.ic_nomal_ac
        Emotion.sad -> R.drawable.ic_angry_ac
        Emotion.angry -> R.drawable.ic_angry_ac
        else -> R.drawable.ic_angry_ac
    }

    imageview.setImageResource(iconId)
}