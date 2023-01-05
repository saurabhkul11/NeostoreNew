package com.example.neostorenew.view.activity.Register

import javax.inject.Inject

class RegisterRepository @Inject constructor(private val registerService: RegisterService) {

    suspend fun createuser(
        first_name: String, last_name: String, email: String,
        password: String, confirm_password: String, gender: String, phone_no: Long
    ) = registerService.register(
        first_name,
        last_name,
        email,
        password,
        confirm_password,
        gender,
        phone_no
    )

}