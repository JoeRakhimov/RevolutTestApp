package com.joerakhimov.revoluttestapp.app

import android.app.Application
import com.joerakhimov.revoluttestapp.di.AppComponent
import com.joerakhimov.revoluttestapp.di.DaggerAppComponent
import com.joerakhimov.revoluttestapp.di.module.AppModule
import com.joerakhimov.revoluttestapp.di.module.ViewModelModule

object Injector {

    lateinit var appComponent: AppComponent

    fun initAppComponent(application: Application) {

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .viewModelModule(ViewModelModule(application))
            .build()

    }

}