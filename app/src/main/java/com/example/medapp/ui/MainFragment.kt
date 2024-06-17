package com.example.medapp.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.example.medapp.data.DataStore
import com.example.medapp.data.ImageViewAdapter
import com.example.medapp.data.Network.MeditationApi
import com.example.medapp.data.Network.MeditationApiServiceImpl
import com.example.medapp.data.Repository.MainRepository
import com.example.medapp.databinding.FragmentMainBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {
    var fragmentMainBinding: FragmentMainBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMainBinding = FragmentMainBinding.bind(view)

        val ava = view.findViewById<ImageView>(R.id.main_avatar)
        val dataStore  = DataStore(requireContext())
        Toast.makeText(requireContext(), dataStore.avatarFlow.toString(), Toast.LENGTH_SHORT).show()
        lifecycleScope.launch {
            dataStore.avatarFlow.collectLatest {
                Picasso.get().load(it).into(ava)
            }
        }

        val  service = MeditationApi.retrofitService
        val serviceImpl = MeditationApiServiceImpl(service)
        val repository: MainRepository = MainRepository(serviceImpl)

        val arrayAdapter = ImageViewAdapter()
        val RecView = view.findViewById<RecyclerView>(R.id.MainRecyclerView)
        RecView.adapter = arrayAdapter
                lifecycleScope.launch {
                    repository.getFeelings().collectLatest{
                        //arrayAdapter.submitList(it)
                    }
                }

        fragmentMainBinding?.MainNav?.setOnItemReselectedListener()
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