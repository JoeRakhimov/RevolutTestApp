package com.joerakhimov.revoluttestapp.screen.currencies

import android.support.v7.util.DiffUtil
import com.joerakhimov.revoluttestapp.screen.currencies.model.rates.Currency

class CurrencyDiffCallback(private val mOldList: List<Currency>, private val mNewList: List<Currency>) : DiffUtil.Callback() {

    override fun getOldListSize() = mOldList.size

    override fun getNewListSize() = mNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        mOldList[oldItemPosition].code == mNewList[newItemPosition].code

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        mOldList[oldItemPosition].rate == mNewList[newItemPosition].rate

}