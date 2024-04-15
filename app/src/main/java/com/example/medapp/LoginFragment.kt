package com.example.medapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    var fragmentLoginBinding: FragmentLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding = FragmentLoginBinding.bind(view)
        //val email = findViewById<EditText>(R.id.LoginName)
        fragmentLoginBinding?.SignIn?.setOnClickListener {
            //if (UserList.IsUserExist(LoginName))
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.host_container)
            }
        }
    }

}