package com.example.neostorenew.di

import android.app.Application

class DaggerApplication:Application() {

    lateinit var appcomponent: Appcomponent
    override fun onCreate() {
        super.onCreate()
        appcomponent=DaggerAppcomponent.builder().sharedPreferenceModule(SharedPreferenceModule(this)).build()

    }
}