package com.example.medapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.medapp.databinding.FragmentTestBinding


class TestFragment : Fragment(R.layout.fragment_test) {
    var fragmentTestBinding:FragmentTestBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentTestBinding = FragmentTestBinding.bind(view)
        fragmentTestBinding?.clickMe?.setOnClickListener {
            parentFragmentManager.commit {
                replace<LoginActivity>(R.id.host_container)
            }
        }
    }
}