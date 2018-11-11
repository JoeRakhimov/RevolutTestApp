package com.joerakhimov.revoluttestapp.di

import com.joerakhimov.revoluttestapp.di.module.*
import com.joerakhimov.revoluttestapp.screen.currencies.CurrenciesAdapter
import com.joerakhimov.revoluttestapp.screen.currencies.CurrenciesFragment
import com.joerakhimov.revoluttestapp.screen.currencies.CurrenciesViewModel
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class, UseCaseModule::class, UtilModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(currenciesViewModel: CurrenciesViewModel)
    fun inject(ratesAdapter: CurrenciesAdapter)
    fun inject(currenciesFragment: CurrenciesFragment)

}