package com.example.medapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.medapp.R
import com.example.medapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    var fragmentProfileBinding: FragmentProfileBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProfileBinding = FragmentProfileBinding.bind(view)
    }
}