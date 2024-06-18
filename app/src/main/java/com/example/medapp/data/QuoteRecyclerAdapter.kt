package com.example.medapp.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medapp.R

class QuoteRecyclerAdapter(private val Quote: List<Quote>) :
    RecyclerView.Adapter<QuoteRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.quotePicture)
        val textDesc : TextView = itemView.findViewById(R.id.quoteDesc)
        val textTitle : TextView = itemView.findViewById(R.id.quoteTitle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.feeling_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return Quote.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(Quote[position].image.toString()).into(holder.img)
        holder.textTitle.text = Quote[position].title.toString()
        holder.textDesc.text = Quote[position].description.toString()
    }
}