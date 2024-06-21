package com.example.medapp.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R
import com.squareup.picasso.Picasso
import com.example.medapp.data.DataStore
import kotlinx.coroutines.launch
import com.example.medapp.databinding.FragmentProfileBinding
import android.content.Context
import com.example.medapp.images.ImageViewAdapter
import com.example.medapp.images.MainViewModel
import com.example.medapp.images.Repository
import com.example.medapp.images.getBitmap
import kotlinx.coroutines.flow.collectLatest

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

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

//        val repository: Repository = Repository(baseContext)
//        val viewModel: MainViewModel = MainViewModel(repository)
//        val recyclerView = view.findViewById<RecyclerView>(R.id.RecProf)
//
//        val arrayAdapter = ImageViewAdapter()
//        viewModel.getImages()
//        recyclerView.adapter = arrayAdapter
//        lifecycleScope.launch {
//            viewModel.uris.collect{
//                arrayAdapter.submitList(it)
//            }
//        }
//        val photoPicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
//            val bitmap = getBitmap(contentResolver, it!!)
//            if (bitmap != null) {
//                viewModel.addImage(bitmap)
//            }
//        }
//
//        button.setOnClickListener {
//            photoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
//        }

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