package com.example.neostorenew.view.activity.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neostorenew.view.activity.Register.RegisterRepository
import com.example.neostorenew.view.activity.Register.RegisterViewModel
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(private val loginRepository: LoginRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
