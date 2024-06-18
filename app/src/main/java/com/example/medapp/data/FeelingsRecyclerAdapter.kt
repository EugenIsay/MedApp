package com.example.medapp.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.medapp.R
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso


class FeelingsRecyclerAdapter(private val Feelings: List<Feeling>) :
    RecyclerView.Adapter<FeelingsRecyclerAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
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
        return Feelings.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(Feelings[position].image.toString()).into(holder.button)
        holder.textView.text = Feelings[position].title.toString()
    }


}