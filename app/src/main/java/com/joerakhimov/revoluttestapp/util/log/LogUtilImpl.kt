package com.joerakhimov.revoluttestapp.util.log

import android.util.Log
import com.joerakhimov.revoluttestapp.app.Constants.LOG_TAG

class LogUtilImpl: LogUtil {

    override fun log(message: String) {
        Log.d(LOG_TAG, message)
    }

}