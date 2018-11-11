package com.joerakhimov.revoluttestapp.util.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.joerakhimov.revoluttestapp.BuildConfig

class ImageLoaderImpl(var context: Context): ImageLoader {

    override fun loadCountryFlag(imageView: ImageView, countryCode: String) {
        var url = BuildConfig.FLAGS_URL + countryCode + ".png"
        Glide.with(context).load(url).into(imageView)
    }

}