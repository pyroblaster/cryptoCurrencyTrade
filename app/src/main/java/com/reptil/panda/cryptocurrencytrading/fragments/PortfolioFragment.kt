package com.reptil.panda.cryptocurrencytrading.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.database.Database

class PortfolioFragment : Fragment() {

    private val coinDataDao by lazy { Database.getCoinDao() }
    private val userDao by lazy { Database.getUserDao() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = userDao.getAll()[0]
        val myPurchases = coinDataDao.getCoinsForUser(user.id)
    }


    companion object {
        fun newInstance(): PortfolioFragment = PortfolioFragment()

    }
}