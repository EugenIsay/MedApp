package com.example.medapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.medapp.R
import androidx.fragment.app.replace
import com.example.medapp.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    var fragmentSplashBinding: FragmentSplashBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSplashBinding = FragmentSplashBinding.bind(view)
        fragmentSplashBinding?.splash?.setOnClickListener {
            parentFragmentManager.commit {
                replace<OnboardingFragment>(R.id.host_container)
            }
        }
    }

}