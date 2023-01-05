package com.example.neostorenew.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.neostorenew.utils.Constant.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class SharedPrefFile  @Inject constructor(private var sharedPreferences: SharedPreferences) {

    fun getToken():String{
       return sharedPreferences.getString(Constants.ACCESS_TOKEN,"")
    }
    fun saveToken(token:String){
        val editor=sharedPreferences.edit()
        editor.putString(Constants.ACCESS_TOKEN,token)
        editor.apply()
    }

}