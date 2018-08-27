package com.reptil.panda.cryptocurrencytrading.fragments



import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.database.CoinPurchaseData
import com.reptil.panda.cryptocurrencytrading.database.Database
import com.reptil.panda.cryptocurrencytrading.ui.adapter.CoinPurchaseDataAdapter
import kotlinx.android.synthetic.main.fragment_portfolio.*

class PortfolioFragment : Fragment() {

    private val adapter = CoinPurchaseDataAdapter()
    private val coinDataDao by lazy { Database.getCoinDao() }
    private val userDao by lazy { Database.getUserDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user_coin_recycler_view.adapter = adapter
        user_coin_recycler_view.layoutManager = LinearLayoutManager(activity)

        val user = userDao.getAll()[0]
        val myPurchases = coinDataDao.getCoinsForUser(user.id)
        val items = listOf<CoinPurchaseData>() // ??
        adapter.setData(items)

    }

    override fun onStart(){
        super.onStart()

        userDao

    }

    companion object {
        fun newInstance(): PortfolioFragment = PortfolioFragment()

    }
}


