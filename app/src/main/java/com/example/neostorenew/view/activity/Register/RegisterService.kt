package com.example.neostorenew.view.activity.Register

import com.example.neostorenew.data.request.RegisterRequest
import com.example.neostorenew.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RegisterService {

    @FormUrlEncoded
    @POST("users/register")

    suspend fun register(
        @Field("first_name") first_name: String,
        @Field("last_name") last_name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirm_password: String,
        @Field("gender") gender: String,
        @Field("phone_no") phone_no: Number
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST("users/login")
    suspend fun loginuser(
        @Field("email")email:String,
        @Field("password")password: String
    ):Response<RegisterResponse>

}