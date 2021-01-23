package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.waters.DataWaters
import com.example.mdietlux.utils.ItemClick

class WaterAdapter (
    val context: Context, val dataList: List<DataWaters>, val itemClick: ItemClick
) : RecyclerView.Adapter<WaterAdapter.ViewHolder>() {

    private var selectedItem = 0

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardWater: CardView = item.findViewById(R.id.cardWaters)
        val textWater: TextView = item.findViewById(R.id.watersName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_waters, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textWater.text = data.name

        if (selectedItem == position) {
            holder.cardWater.setCardBackgroundColor(context.resources.getColor(R.color.green_500))
        } else {
            holder.cardWater.setCardBackgroundColor(context.resources.getColor(R.color.five))
        }

        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}