package com.example.medapp.ui


import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.lifecycleScope
import com.example.medapp.R
import com.example.medapp.data.DataStore
import com.example.medapp.databinding.FragmentProfileBinding
import com.example.medapp.images.MainViewModel
import com.example.medapp.images.ProfilePicturesAdapter
import com.example.medapp.images.Repository
import com.example.medapp.images.getBitmap
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var photoPicker: ActivityResultLauncher<PickVisualMediaRequest>
    private lateinit var viewModel: MainViewModel
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
        val rep = Repository(requireContext())
        viewModel = MainViewModel(rep)
        photoPicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            it?.let {
                val bitmap = getBitmap(requireContext().contentResolver, it)
                if (bitmap != null) viewModel.addImage(bitmap)
            }
        }

        val ProfilePicturesAdapter = ProfilePicturesAdapter(
            click = { uri -> openPhoto(uri) },
            addClick = { openPhotoPicker() }
        )
        viewModel.getImages()
        fragmentProfileBinding!!.RecProf.adapter = ProfilePicturesAdapter
        lifecycleScope.launch {
            viewModel.uris.collect {
                ProfilePicturesAdapter.submitList(it)
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
    private fun openPhoto(uri: Uri) {
        val PFragment = PhotoFragment()

        val bundle = Bundle()
        bundle.putString("uri", uri.toString())
        PFragment.setArguments(bundle)
        parentFragmentManager.commit {
            replace(R.id.host_container, PFragment)
        }
    }

    private fun openPhotoPicker() {
        photoPicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
}