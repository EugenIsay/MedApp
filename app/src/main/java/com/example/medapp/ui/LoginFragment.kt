package com.example.medapp.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.medapp.R
import com.example.medapp.data.Network.MeditationApi
import com.example.medapp.data.Network.MeditationApiServiceImpl
import com.example.medapp.data.UserLogin
import com.example.medapp.databinding.FragmentLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {
    var fragmentLoginBinding: FragmentLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)
        val password: EditText = view.findViewById(R.id.LoginPassword)
        val email: EditText = view.findViewById(R.id.LoginEmail)
        val  service = MeditationApi.retrofitService
        val serviceImpl = MeditationApiServiceImpl(service)
        fragmentLoginBinding?.SignIn?.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Main) {
                    val user = UserLogin(email.text.toString(), password.text.toString())
                    val TryLogin = serviceImpl.login(user)
                    if (TryLogin.isSuccessful)
                    {
                    }
                }
        }
    }
}