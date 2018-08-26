package com.reptil.panda.cryptocurrencytrading.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.database.CoinDataDao
import com.reptil.panda.cryptocurrencytrading.database.CoinPurchaseData
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import com.reptil.panda.cryptocurrencytrading.network.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_trade.*
import java.util.concurrent.TimeUnit


class TradeFragment : Fragment() {

    private val coinDataDao by lazy { Database.getCoinDao() }
    private val userDao by lazy { Database.getUserDao() }

    private var currentCoin: CoinModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_trade, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        buyButton.setOnClickListener { onBuyClicked() }
        sellButton.setOnClickListener { onSellClicked() }

        RxTextView.textChanges(coinName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter { it.length >= 3 }
                .map { it.toString() }
                .subscribe(::searchCoin, Throwable::printStackTrace)
    }

    private fun searchCoin(query: String) {
        RetrofitUtil.apiService.getCoin(query).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onCoinReceived, ::onCoinNotFound)
    }

    private fun onCoinNotFound(throwable: Throwable?) {
        throwable?.printStackTrace()

        tradePrice.text = null
        currentCoin = null
    }

    private fun onCoinReceived(coinData: List<CoinModel?>?) {
        val coin = coinData?.getOrNull(0)

        coin?.run {
            currentCoin = coin
            tradePrice.text = priceUsd
        }
    }

    private fun onBuyClicked() {
        val coin = coinName.text.toString()
        val amount = tradeAmount.text.toString().toDouble()
        val tradePrice = tradePrice.text.toString()

        currentCoin = CoinModel().apply {
            id = "bitcoin"
            priceUsd = "205.0 "
        }

        if (!tradePrice.isBlank()) {
            val user = userDao.getAll().first()
            val totalCost = tradePrice.toDouble() * amount

            if (user.currentFiatAmount > totalCost) {
                user.currentFiatAmount = user.currentFiatAmount - totalCost
                userDao.insert(user)

                currentCoin?.run { buyCoin(this, amount, coin) }
            }
        }
    }

    private fun buyCoin(coinModel: CoinModel, amount: Double, coinName: String) {
        val user = userDao.getAll().first()

        val newPurchase = CoinPurchaseData(coinId = coinModel.id,
                userId = user.id,
                coinName = coinName,
                amount = amount,
                currentPrice = coinModel.priceUsd?.toDouble() ?: 0.0,
                timestamp = System.currentTimeMillis()
        )

        coinDataDao.storePurchase(newPurchase)
    }

    private fun onSellClicked() {
        val coin = coinName.text.toString()
        val amount = tradeAmount.text.toString().toDouble()
        val tradePrice = tradePrice.text.toString()

        if (!tradePrice.isBlank()) {
            val user = userDao.getAll().first()
            val myCoin = coinDataDao.getCoinsForUser(user.id).firstOrNull { it.coinId == coin }
                    ?: return

            if (myCoin.amount >= amount) {
                val totalCost = tradePrice.toDouble() * amount

                user.currentFiatAmount += totalCost
                userDao.insert(user)

                myCoin.amount -= amount

                coinDataDao.storePurchase(myCoin)
            }
        }
    }

    companion object {
        fun newInstance(): TradeFragment = TradeFragment()

    }


}