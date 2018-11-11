package com.joerakhimov.revoluttestapp.usecase.currencies

import com.joerakhimov.revoluttestapp.data.api.Api
import com.joerakhimov.revoluttestapp.screen.currencies.model.names.CurrencyNamesResponse
import com.joerakhimov.revoluttestapp.screen.currencies.model.rates.CurrencyRatesResponse
import com.joerakhimov.revoluttestapp.util.concurrency.scheduler.SchedulerProvider
import io.reactivex.Observable

class CurrenciesUseCaseImpl(private val api: Api, private val schedulerProvider: SchedulerProvider): CurrenciesUseCase {

    override fun getNames(): Observable<CurrencyNamesResponse> {
        return api.getCurrencyNames()
            .subscribeOn(schedulerProvider.io)
    }

    override fun getRates(base: String): Observable<CurrencyRatesResponse> {
        return api.getCurrencyRates(base)
            .subscribeOn(schedulerProvider.io)
    }

}