package com.example.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CryptoFragment : Fragment() {

    private val ratesBtn: Button by lazy { findView<Button>(R.id.main_flow_to_rates_btn)!! }
    private val exchangeBtn: Button by lazy { findView<Button>(R.id.crypto_to_exchange_btn)!! }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.crypto_fragment_layout, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ratesBtn.setOnClickListener { (activity as MainActivity).navigate(MainNavigation.RatesFragment) }
        exchangeBtn.setOnClickListener { (activity as MainActivity).navigate(MainFlow.Exchange) }
    }
}

class ExchangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exchange_fragment_layout, container,false)
    }
}