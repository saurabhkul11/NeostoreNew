package com.example.neostorenew.di

import android.app.Application
import android.content.Context
import com.example.neostorenew.MainActivity
import com.example.neostorenew.api.ApiService
import com.example.neostorenew.view.activity.Login.LoginActivity
import com.example.neostorenew.view.activity.Register.RegisterActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiService::class,SharedPreferenceModule::class])


interface Appcomponent {
   fun inject(loginActivity: LoginActivity)
   fun inject(registerActivity: RegisterActivity)


}
