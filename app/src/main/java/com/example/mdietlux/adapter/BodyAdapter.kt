package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mdietlux.R
import com.example.mdietlux.data.model.body.DataBody
import com.example.mdietlux.utils.ItemClick

class BodyAdapter (val context: Context, val dataBodyList : List<DataBody>, val itemClick: ItemClick) : RecyclerView.Adapter<BodyAdapter.ViewHolder>()  {


    class ViewHolder (item: View) : RecyclerView.ViewHolder(item){
        val imageBody : ImageView = item.findViewById(R.id.imageBody)
        val textBody : TextView = item.findViewById(R.id.textBody)
        val textBodyInfo : TextView = item.findViewById(R.id.textBodyInfo)
        val cardView : CardView = item.findViewById(R.id.cardBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_body, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataBodyList[position]
        holder.textBody.text = dataModel.name
        holder.textBodyInfo.text = dataModel.description
        Glide.with(context)
            .load("https://mdietlux.com/" + dataModel.image)
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageBody)
        holder.cardView.setOnClickListener {
            itemClick.clicked(position)
        }
    }

    override fun getItemCount(): Int {
        return dataBodyList.size
    }
}