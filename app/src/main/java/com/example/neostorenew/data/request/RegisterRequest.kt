package com.example.neostorenew.data.request

data class RegisterRequest(
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val confirm_password: String,
    val gender: String,
    val phone_no:Number
)
