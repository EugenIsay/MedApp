package com.example.medapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.R
import com.example.medapp.data.Network.MeditationApIService
import com.example.medapp.data.Network.MeditationApi
import com.example.medapp.data.User
import com.example.medapp.data.UserLogin
import com.example.medapp.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class LoginFragment : Fragment(R.layout.fragment_login) {
    var fragmentLoginBinding: FragmentLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)
        //val email = findViewById<EditText>(R.id.LoginName)
        fragmentLoginBinding?.SignIn?.setOnClickListener {
            parentFragmentManager.commit {
            //if (UserList.IsUserExist(LoginName))
                replace<LoginFragment>(R.id.host_container)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            val user : UserLogin = UserLogin("a", "a")

            val a = MeditationApi.retrofitService.login(user)
        }
    }
}