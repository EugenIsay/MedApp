package com.example.medapp.data



data class UserLogin(val email:String, val password:String)


data class User(val id:String, val email: String, val nickName:String, val avatar:String, val token:String)
