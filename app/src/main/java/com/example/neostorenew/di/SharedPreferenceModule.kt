package com.example.neostorenew.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SharedPreferenceModule(private val application: Application) {

    @Singleton
    @Provides
    fun getSharedPref(context: Context): SharedPreferences {
        return context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun getApplication(): Context=application

    @Singleton
    @Provides
    fun provideApplication(): Application=application



}