package com.example.medapp.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.medapp.R
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.squareup.picasso.Picasso


class CustomRecyclerAdapter(private val Feelings: List<Feeling>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val linearLayout : LinearLayout = itemView.findViewById(R.id.feelingItem)
        val button : ImageView = itemView.findViewById(R.id.feelButton)
        val textView : TextView = itemView.findViewById(R.id.feelText)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.feeling_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(Feelings[position].image.toString()).into(holder.button)
        holder.textView.text = Feelings[position].title.toString()
    }


}