package com.joerakhimov.revoluttestapp.util.code

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class CodeConverterTest{

    var SUT: CodeConverter? = null

    @Before
    fun setup(){
        SUT = CodeConverterImpl()
    }

    @Test
    fun convert_currencyCode_countryCodeInLowerCaseReturned() {
        var result = SUT?.convertCurrencyCodeToCountryCodeInLowercase("USD")
        assertThat(result, `is`("us"))
    }

}