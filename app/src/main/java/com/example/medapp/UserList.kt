package com.example.medapp

object UserList {
    val userList = mutableListOf<User>()
    fun AddUser (Name: String, Email: String, Password: String, ComfPass: String)
    {
        if (!IsUserExist(Email) && Password == ComfPass) {
            val NewUser = User(Name, Email, Password)
            userList.add(NewUser)
        }
    }
    fun IsUserExist (Email: String) : Boolean
    {
        return userList.any { it.Email == Email }
    }

}