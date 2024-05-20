package com.example.medapp.data

import java.lang.Exception

sealed class MeditationResponseState<T>(data: T? = null, exception: Exception? = null) {
    data class Success<T>(val data:T): MeditationResponseState<T>(data, null)
    data class Error<T>(val exception: Exception): MeditationResponseState<T>(null, exception)
}