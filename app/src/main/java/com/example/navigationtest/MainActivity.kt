package com.example.navigationtest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navigate(navigation: MainNavigation){
        when (navigation) {
            MainNavigation.MainFlow -> findNavController(R.id.main_navigation_fragment).navigate(R.id.action_login_to_main_flow)
            MainNavigation.RatesFragment-> findNavController(R.id.main_navigation_fragment).navigate(R.id.action_main_flow_to_rates)
            else->{}
        }
    }

    fun navigate(navigation: MainFlow) {
        when(navigation){
            MainFlow.Exchange -> findNavController(R.id.main_flow_navigation_fragment).navigate(R.id.crypto_fragment_to_exchange)
            MainFlow.Crypto -> findNavController(R.id.main_flow_navigation_fragment).navigate(R.id.exchange_fragment_to_crypto)
        }
    }
}

enum class MainNavigation { Login, MainFlow, RatesFragment }
enum class MainFlow { Crypto, Exchange }

inline fun <reified T : View> View?.findView(id: Int): T? = when (this) {
    null -> null
    else -> findViewById(id)
}

inline fun <reified T : View> Fragment.findView(id: Int): T? = view.findView(id)
