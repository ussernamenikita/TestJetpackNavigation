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

    fun navigateToMainFlow() =
        findNavController(R.id.main_navigation_fragment).navigate(R.id.action_login_to_main_flow)
}

inline fun <reified T : View> View?.findView(id: Int): T? = when (this) {
    null -> null
    else -> findViewById(id)
}

inline fun <reified T : View> Fragment.findView(id: Int): T? = view.findView(id)
