package com.joerakhimov.revoluttestapp.data.api

import com.joerakhimov.revoluttestapp.screen.currencies.model.names.CurrencyNamesResponse
import com.joerakhimov.revoluttestapp.screen.currencies.model.rates.CurrencyRatesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("latest")
    fun getCurrencyRates(@Query("base") base: String): Observable<CurrencyRatesResponse>

    @GET("https://openexchangerates.org/api/currencies.json")
    fun getCurrencyNames(): Observable<CurrencyNamesResponse>

}