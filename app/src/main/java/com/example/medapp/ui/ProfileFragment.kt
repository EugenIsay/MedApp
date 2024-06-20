package com.example.medapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.example.medapp.R
import com.squareup.picasso.Picasso
import com.example.medapp.data.DataStore
import com.example.medapp.databinding.FragmentProfileBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    var fragmentProfileBinding: FragmentProfileBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentProfileBinding = FragmentProfileBinding.bind(view)
        val ava = view.findViewById<ImageView>(R.id.prof_avatar)
        val NameText = view.findViewById<TextView>(R.id.textProf)
        val dataStore  = DataStore(requireContext())
        lifecycleScope.launch {
            dataStore.avatarFlow.collectLatest {
                Picasso.get().load(it).into(ava)
            }
            dataStore.nameFlow.collectLatest {
                NameText.text = it;
            }
        }
        lifecycleScope.launch {
            dataStore.nameFlow.collectLatest {
                NameText.text = it;
            }
        }


        fragmentProfileBinding?.profExit?.setOnClickListener()
        {
            parentFragmentManager.commit {
                replace<LoginFragment>(R.id.host_container)
            }
        }


        fragmentProfileBinding?.ProfNavig?.setOnItemReselectedListener()
        {
            if (it.itemId == R.id.home)
            {
                parentFragmentManager.commit {
                    replace<MainFragment>(R.id.host_container)
                }
            }
            else if (it.itemId == R.id.mus)
            {

            }
            else if (it.itemId == R.id.user)
            {
                parentFragmentManager.commit {
                    replace<ProfileFragment>(R.id.host_container)
                }
            }


        }
    }
}