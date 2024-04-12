package com.example.medapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.ActivityLoginBinding
import com.example.medapp.databinding.FragmentTestBinding

class LoginActivity : Fragment(R.layout.activity_login) {
    var activityLoginBinding: ActivityLoginBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityLoginBinding = ActivityLoginBinding.bind(view)
        activityLoginBinding?.ToReg?.setOnClickListener {
            parentFragmentManager.commit {
                replace<RegistrActivity>(R.id.host_container)
            }
        }
    }

}