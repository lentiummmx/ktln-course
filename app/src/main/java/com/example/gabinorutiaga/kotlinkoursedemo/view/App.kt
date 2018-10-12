package com.example.gabinorutiaga.kotlinkoursedemo.view

import android.app.Application
import android.content.Context

class App: Application() {

    companion object {
        private lateinit var sApplicationContext: Context

        fun getContext(): Context {
            return sApplicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        sApplicationContext = this
    }
}