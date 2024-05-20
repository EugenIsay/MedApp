package com.example.medapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.medapp.R
import com.example.medapp.databinding.FragmentMainBinding
import com.example.medapp.databinding.FragmentOnboardingBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    var fragmentMainBinding: FragmentMainBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMainBinding = FragmentMainBinding.bind(view)
    }

}