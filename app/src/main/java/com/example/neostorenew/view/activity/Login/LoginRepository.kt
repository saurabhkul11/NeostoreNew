package com.example.neostorenew.view.activity.Login

import com.example.neostorenew.view.activity.Register.RegisterService
import javax.inject.Inject

class LoginRepository @Inject constructor(val registerService: RegisterService){
    suspend fun loginuser(email:String,password:String)=registerService.loginuser(email, password)
}