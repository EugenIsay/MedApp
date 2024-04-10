package com.example.medapp

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(val startname: String, val startemail: String, val startpassword: String)
{
    var _name : String = startname
    var Name: String
        get() = _name
        set(value) {_name = value}

    var _email : String = startemail
    var Email: String
        get() = _email
        set(value) {_email = value}

    var _password : String = startpassword
    var Password: String
        get() = _password
        set(value) {_password = value}
}
