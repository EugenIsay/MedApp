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
import com.example.medapp.data.FeelingsRecyclerAdapter
import com.example.medapp.data.DataStore
import com.example.medapp.data.Network.MeditationApi
import com.example.medapp.data.Network.MeditationApiServiceImpl
import com.example.medapp.data.QuoteRecyclerAdapter
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
        lifecycleScope.launch {
            dataStore.avatarFlow.collectLatest {
                Picasso.get().load(it).into(ava)
            }
        }

        val  service = MeditationApi.retrofitService
        val serviceImpl = MeditationApiServiceImpl(service)


        val RecView = view.findViewById<RecyclerView>(R.id.MainRecyclerView)
        lifecycleScope.launch {
            RecView.adapter = FeelingsRecyclerAdapter(serviceImpl.getFeeling().data);
        }

        val RecView2 = view.findViewById<RecyclerView>(R.id.QuoteRec)
        lifecycleScope.launch {
            RecView2.adapter = QuoteRecyclerAdapter(serviceImpl.getQuote().data.toMutableList());
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