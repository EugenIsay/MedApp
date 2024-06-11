package com.example.medapp.data.Network

import com.example.medapp.data.FeelingResponse
import com.example.medapp.data.QuoteResponse
import com.example.medapp.data.User
import com.example.medapp.data.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MeditationApIService {
    @POST("user/login")
    suspend fun login(@Body login: UserLogin): Response<User>

    @GET("quotes")
    suspend fun getQuotes():QuoteResponse

    @GET("feelings")
    suspend fun getFeelings():FeelingResponse
}