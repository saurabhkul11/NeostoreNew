package com.example.neostorenew.data.response
import android.R

data class RegisterResponse(
    val `data`: UserData,
    val message: String,
    val status: Int,
    val user_msg: String
)

data class UserData(
    val access_token: String,
    val country_id: Any,
    val created: String,
    val dob: String,
    val email: String,
    val first_name: String,
    val gender: String,
    val id: Int,
    val is_active: Boolean,
    val last_name: String,
    val modified: String,
    val phone_no: Number,
    val profile_pic: String,
    val role_id: Int,
    val username: String
)