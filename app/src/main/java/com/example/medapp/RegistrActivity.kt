package com.example.medapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.ActivityLoginBinding
import com.example.medapp.databinding.ActivityRegisterBinding

class RegistrActivity : Fragment(R.layout.activity_register) {
    var activityRegisterBinding: ActivityRegisterBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.bind(view)
        activityRegisterBinding?.ToLogin?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginActivity>(R.id.host_container)
            }
        }
    }

}