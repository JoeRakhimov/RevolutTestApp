package com.joerakhimov.revoluttestapp.usecase.currencies

import com.joerakhimov.revoluttestapp.screen.currencies.model.names.CurrencyNamesResponse
import com.joerakhimov.revoluttestapp.screen.currencies.model.rates.CurrencyRatesResponse
import io.reactivex.Observable

interface CurrenciesUseCase {

    fun getNames(): Observable<CurrencyNamesResponse>
    fun getRates(base: String): Observable<CurrencyRatesResponse>

}