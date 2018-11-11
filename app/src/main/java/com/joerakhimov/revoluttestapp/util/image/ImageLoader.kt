package com.joerakhimov.revoluttestapp.util.image

import android.widget.ImageView

interface ImageLoader {

    fun loadCountryFlag(imageView: ImageView, countryCode: String)

}