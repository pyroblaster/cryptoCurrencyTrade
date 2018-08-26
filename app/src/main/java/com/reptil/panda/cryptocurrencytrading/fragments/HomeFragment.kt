package com.reptil.panda.cryptocurrencytrading.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.reptil.panda.cryptocurrencytrading.R
import com.reptil.panda.cryptocurrencytrading.model.CoinModel
import com.reptil.panda.cryptocurrencytrading.network.RetrofitUtil
import com.reptil.panda.cryptocurrencytrading.ui.adapter.CoinModelAdapter
import com.reptil.panda.cryptocurrencytrading.ui.view.CoinModelViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val adapter = CoinModelAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coin_recycler_view.adapter = adapter
        coin_recycler_view.layoutManager = LinearLayoutManager(activity)

        val items = listOf<CoinModel>()

        adapter.setData(items) //podaci koje dobijes s neta
    }

    override fun onStart() {
        super.onStart()

        RetrofitUtil.apiService.getCoinData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::setData, Throwable::printStackTrace)
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()

    }
}