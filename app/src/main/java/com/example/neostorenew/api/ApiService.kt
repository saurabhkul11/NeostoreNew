package com.example.neostorenew.api

import com.example.neostorenew.utils.Constant.Constants
import com.example.neostorenew.view.activity.Register.RegisterService
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//@Module
//class ApiService {
//    @Singleton
//    @Provides
//    fun getRetrofit(): Retrofit {
//        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(getHttpClient())
//            .build()
//    }
//
//
//    @Singleton
//    @Provides
//    fun getHttpClient(): OkHttpClient {
//
//        return OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
//            .addNetworkInterceptor(StethoInterceptor())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun retrofitService(retrofit: Retrofit): RegisterService {
//        return retrofit.create(RegisterService::class.java)
//    }
//}
    @Module
    class ApiService {

    // 10 MB
    private val READ_TIMEOUT = 30
    private val WRITE_TIMEOUT = 30
    private val CONNECTION_TIMEOUT = 10

    @Singleton
    @Provides
        fun provideOkhttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClientBuilder = OkHttpClient().newBuilder()
            okHttpClientBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)

            okHttpClientBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            okHttpClientBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)

            return okHttpClientBuilder.build()
        }

//     @Singleton
//    @Provides
//    fun getHttpClient(): OkHttpClient {
//
//        return OkHttpClient.Builder()
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
//            //.addNetworkInterceptor(())
//            .build()
//    }

        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        }


    @Singleton
    @Provides
    fun retrofitService(retrofit: Retrofit): RegisterService {
        return retrofit.create(RegisterService::class.java)
    }
}