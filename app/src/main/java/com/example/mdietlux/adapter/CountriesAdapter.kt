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
import com.example.mdietlux.data.model.countries.DataCountries
import com.example.mdietlux.utils.ItemClick

class CountriesAdapter(val context: Context, val dataList: List<DataCountries>, val itemClick: ItemClick) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private var selectedItem = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_countries, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.textClassified.text = dataModel.name

        Glide.with(context)
                .load("https://mdietlux.com/" + dataModel.image)
                .centerInside()
                .override(250)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageClassified)

        if (selectedItem == position) {
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.green_500))
        } else {
            holder.cardView.setCardBackgroundColor(context.resources.getColor(R.color.five))
        }

        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }

        holder.cardView.setOnClickListener {
            itemClick.clicked(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imageClassified: ImageView = item.findViewById(R.id.imageCountries)
        val textClassified: TextView = item.findViewById(R.id.textCountries)
        val cardView: CardView = item.findViewById(R.id.cardCountries)
    }
}