package com.example.kotlin.examen_a01709413_uri.data.network


import com.example.kotlin.examen_a01709413_uri.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val originalRequest = chain.request()
            val requestWithApiKey = originalRequest.newBuilder()
                .header("X-Api-Key", Constants.TOKEN)
                .build()
            chain.proceed(requestWithApiKey)
        })
        .build()

    operator fun invoke(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(ApiService::class.java)
    }
}
