package com.barryzea.mydealsapp.model

import com.barryzea.mydealsapp.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiAdapter {


    fun getClientService(): ApiService {
        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("API_KEY", Constants.API_KEY)
                .addQueryParameter("format", "json")
                .build()
            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(newRequest)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.URL_API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

}