package com.example.medapp.data.Network

import com.example.medapp.data.UserLogin

class MeditationApiServiceImpl(private val meditationApIService: MeditationApIService) {
    suspend fun login(userLogin: UserLogin) = meditationApIService.login(userLogin)
    suspend fun getQuote() = meditationApIService.getQuotes()
    suspend fun getFeeling() = meditationApIService.getFeelings()

}