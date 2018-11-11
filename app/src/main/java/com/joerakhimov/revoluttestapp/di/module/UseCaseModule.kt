package com.joerakhimov.revoluttestapp.di.module

import com.joerakhimov.revoluttestapp.data.api.Api
import com.joerakhimov.revoluttestapp.usecase.currencies.CurrenciesUseCase
import com.joerakhimov.revoluttestapp.usecase.currencies.CurrenciesUseCaseImpl
import com.joerakhimov.revoluttestapp.util.concurrency.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideCurrenciesUseCase(api: Api, schedulerProvider: SchedulerProvider): CurrenciesUseCase
            = CurrenciesUseCaseImpl(api, schedulerProvider)

}