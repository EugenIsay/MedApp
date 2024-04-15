package com.example.medapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.FragmentRegisterBinding

class RegistrFragment : Fragment(R.layout.fragment_register) {
    var fragmentRegisterBinding: FragmentRegisterBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentRegisterBinding = FragmentRegisterBinding.bind(view)
        fragmentRegisterBinding?.ToLogin?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.host_container)
            }
        }
    }

}