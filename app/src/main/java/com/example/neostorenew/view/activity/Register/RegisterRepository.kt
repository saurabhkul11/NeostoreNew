package com.example.neostorenew.view.activity.Register

import com.example.neostorenew.data.request.RegisterRequest
import javax.inject.Inject

class RegisterRepository @Inject constructor(val registerService: RegisterService) {

    //suspend fun createuser(user:RegisterRequest)=registerService.register(user)
    suspend fun createuser(first_name: String, last_name: String, email: String, password: String, confirm_password: String, gender: String, phone_no: Long) = registerService.register(first_name, last_name, email, password, confirm_password, gender, phone_no
    )

}