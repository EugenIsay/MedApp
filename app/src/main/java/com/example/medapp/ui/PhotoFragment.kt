package com.example.medapp.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.medapp.R
import com.example.medapp.databinding.FragmentPhotoBinding
import com.example.medapp.images.MainViewModel
import com.example.medapp.images.Repository


class PhotoFragment : Fragment(R.layout.fragment_photo) {

    private lateinit var binding: FragmentPhotoBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoBinding.bind(view)
        repository = Repository(requireContext())
        viewModel = MainViewModel(repository)
        val uri: Uri?;
        val bundle = arguments
        if (bundle != null) {
            uri = Uri.parse(bundle.getString("uri"))
        }
        else
        {
            uri = null;
        }

        if (uri != null) {
            binding.Photo.setImageURI(uri)

            // Delete
            binding.buttonDelete.setOnClickListener {
                deleteImage(uri)
            }

            // Close
            binding.buttonClose.setOnClickListener {
                parentFragmentManager.commit {
                    replace<ProfileFragment>(R.id.host_container)
                }
            }
        }
    }

    private fun deleteImage(uri: Uri) {
        val isDeleted = repository.deleteImage(uri)
        if (isDeleted) {
            parentFragmentManager.commit {
                replace<ProfileFragment>(R.id.host_container)
            }
        } else {
            Toast.makeText(requireContext(), "Ошибка во время удаления изображения", Toast.LENGTH_SHORT).show()
        }
    }

}