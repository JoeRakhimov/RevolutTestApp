package com.joerakhimov.revoluttestapp.screen.currencies


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joerakhimov.revoluttestapp.R
import com.joerakhimov.revoluttestapp.app.Injector
import kotlinx.android.synthetic.main.fragment_rates.*
import javax.inject.Inject

class CurrenciesFragment : Fragment() {

    @Inject
    lateinit var mViewModel: CurrenciesViewModel

    var mRatesAdapter: CurrenciesAdapter? = null

    companion object {
        @JvmStatic
        fun newInstance() = CurrenciesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        Injector.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.currencies)

        mRatesAdapter = CurrenciesAdapter()
        var layoutManager = LinearLayoutManager(context)
        recycler.layoutManager = layoutManager
        recycler.adapter = mRatesAdapter

        mRatesAdapter?.setBaseCurrencySubject(mViewModel.getBaseCurrencySubject())

        mViewModel.getCurrenciesSubject()
            .doOnNext {
                mRatesAdapter?.swap(it)
                if(mViewModel.getShowProgress().value!!){
                    recycler.scrollToPosition(0)
                }
            }
            .subscribe()

        mViewModel.getShowProgress().doOnNext {
            loading.visibility = if(it) View.VISIBLE else View.GONE
        }.subscribe()

    }

    override fun onStart() {
        super.onStart()
        mViewModel.onStart()
    }

    override fun onStop() {
        super.onStop()
        mViewModel.onStop()
    }

}
