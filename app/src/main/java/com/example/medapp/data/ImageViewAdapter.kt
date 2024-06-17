package com.example.medapp.data

import android.net.Uri
import android.view.LayoutInflater
import com.example.medapp.R
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ImageViewAdapter() : ListAdapter<Uri, ImageViewAdapter.ViewHolder>(ImageViewCallback) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val linearLayout : LinearLayout = view.findViewById(R.id.feelingItem)
        val button : ImageView = view.findViewById(R.id.feelButton)
        val textView : TextView = view.findViewById(R.id.feelText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feeling_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.button.setImageURI(getItem(position))
        holder.textView.setText(getItem(position).toString())
    }


    object ImageViewCallback: DiffUtil.ItemCallback<Uri>() {
        override fun areItemsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Uri, newItem: Uri): Boolean {
            return oldItem == newItem
        }

    }
}