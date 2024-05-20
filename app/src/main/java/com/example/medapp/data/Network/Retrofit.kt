package com.example.medapp.data.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MeditationApi {
    private  const val BASE_URL = "http://mskko2021.mad.hakta.pro/api/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val retrofitService: MeditationApIService by lazy {
        retrofit.create(MeditationApIService::class.java)
    }
}