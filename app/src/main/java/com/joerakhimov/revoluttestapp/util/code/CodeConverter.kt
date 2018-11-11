package com.joerakhimov.revoluttestapp.util.code

interface CodeConverter {

    fun convertCurrencyCodeToCountryCodeInLowercase(currencyCode: String?): String?

}