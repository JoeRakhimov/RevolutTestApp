package com.joerakhimov.revoluttestapp.di.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.joerakhimov.revoluttestapp.screen.currencies.CurrenciesViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(private var application: Application) {

    @Provides
    fun provideCurrenciesViewModel() =
        AndroidViewModelFactory.getInstance(application).create(CurrenciesViewModel::class.java)

}