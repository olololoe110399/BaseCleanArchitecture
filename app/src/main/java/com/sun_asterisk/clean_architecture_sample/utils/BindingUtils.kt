package com.sun_asterisk.clean_architecture_sample.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sun_asterisk.clean_architecture_sample.R
import com.sun_asterisk.shared.constants.Constants

@BindingAdapter("bindImage")
fun ImageView.loadImageUrl(imagePath: String?) {
    if (imagePath.isNullOrEmpty()) {
        setImageResource(
            listOf(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark).random()
        )
        return
    }
    Glide.with(context)
        .load(Constants.BASE_URL_IMAGE + imagePath)
        .placeholder(
            listOf(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark).random()
        )
        .into(this)
}
