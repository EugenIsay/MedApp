package com.example.medapp.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.example.medapp.R
import com.example.medapp.data.DataStore
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
        val dataStore = DataStore(requireContext())
        fragmentLoginBinding?.SignIn?.setOnClickListener {
                lifecycleScope.launch(Dispatchers.Main) {
                    val user = UserLogin(email.text.toString(), password.text.toString())
                    val TryLogin = serviceImpl.login(user)
                    if (TryLogin.isSuccessful)
                    {
                        var sample = TryLogin.body()
                        if (sample != null) {
                            Toast.makeText(requireContext(), sample.avatar, Toast.LENGTH_SHORT).show()
                            dataStore.setUser(sample)
                        };
                        parentFragmentManager.commit {
                            replace<MainFragment>(R.id.host_container)
                        }
                    }
                }
        }
    }
}