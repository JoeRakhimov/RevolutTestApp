package com.joerakhimov.revoluttestapp.screen.currencies

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import com.joerakhimov.revoluttestapp.R
import com.joerakhimov.revoluttestapp.app.Injector
import com.joerakhimov.revoluttestapp.screen.currencies.model.rates.Currency
import com.joerakhimov.revoluttestapp.util.code.CodeConverter
import com.joerakhimov.revoluttestapp.util.image.ImageLoader
import com.joerakhimov.revoluttestapp.util.text.TextUtil
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.listitem_rate.view.*
import javax.inject.Inject


class CurrenciesAdapter : RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {

    @Inject
    lateinit var mCodeConverter: CodeConverter

    @Inject
    lateinit var mImageLoader: ImageLoader

    @Inject
    lateinit var textUtil: TextUtil

    init {
        Injector.appComponent.inject(this)
    }

    private var mBaseCurrencySubject = BehaviorSubject.create<Currency>()
    private var mCurrencies = ArrayList<Currency>()
    private var mBaseCurrencyAmountInputDisposable: Disposable? = null

    fun swap(currencies: List<Currency>) {
        val diffCallback = CurrencyDiffCallback(mCurrencies, currencies)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.mCurrencies.clear()
        this.mCurrencies.addAll(currencies)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = mCurrencies.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_rate, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CurrenciesAdapter.ViewHolder, position: Int) {

        var currency = mCurrencies[position]

        // flag icon
        var countryCode = mCodeConverter.convertCurrencyCodeToCountryCodeInLowercase(currency.code)
        if (countryCode != null) mImageLoader.loadCountryFlag(holder.view.ivFlag, countryCode)
        // code
        holder.view.tvCode.text = currency.code
        // name
        holder.view.tvName.text = currency.name
        // rate
        var formattedRateWithTwoDecimalPlaces = textUtil.formatWithTwoDecimalPlaces(currency.rate)
        holder.view.etRate.setText(formattedRateWithTwoDecimalPlaces)

        // rate changes listener
        if (position == 0 && (mBaseCurrencyAmountInputDisposable == null || mBaseCurrencyAmountInputDisposable!!.isDisposed)) {
            mBaseCurrencyAmountInputDisposable = RxTextView.textChanges(holder.view.etRate).subscribe { text ->
                if (text.isNotEmpty()) currency.rate = text.toString().toDouble()
                else currency.rate = 0.0
                mBaseCurrencySubject.onNext(currency)
            }
        }

        // click listener
        holder.view.setOnClickListener {
            mBaseCurrencyAmountInputDisposable?.dispose()
            mBaseCurrencySubject.onNext(currency)
        }

    }

    fun setBaseCurrencySubject(baseCurrencySubject: BehaviorSubject<Currency>) {
        mBaseCurrencySubject = baseCurrencySubject
    }

}