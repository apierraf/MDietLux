package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.day.DataDays
import com.example.mdietlux.utils.ItemClick

class DayAdapter(
    val context: Context, val dataList: List<DataDays>, val itemClick: ItemClick
) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardDay: CardView = item.findViewById(R.id.cardDay)
        val textDay: TextView = item.findViewById(R.id.dayName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_day, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textDay.text = data.name


        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}