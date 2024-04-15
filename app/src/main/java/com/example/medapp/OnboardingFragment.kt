package com.example.medapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.FragmentOnboardingBinding
import com.example.medapp.databinding.FragmentRegisterBinding

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {
    var fragmentOnboardingBinding: FragmentOnboardingBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentOnboardingBinding = FragmentOnboardingBinding.bind(view)
        fragmentOnboardingBinding?.signIn?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.host_container)
            }
        }
        fragmentOnboardingBinding?.SignUp?.setOnClickListener {
            parentFragmentManager.commit {
                replace<RegistrFragment>(R.id.host_container)
            }
        }
    }

}