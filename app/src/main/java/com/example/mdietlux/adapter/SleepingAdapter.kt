package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.sleeping.DataSleeping
import com.example.mdietlux.utils.ItemClick

class SleepingAdapter(
    val context: Context, val dataList: List<DataSleeping>, val itemClick: ItemClick
) : RecyclerView.Adapter<SleepingAdapter.ViewHolder>() {


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardSleep: CardView = item.findViewById(R.id.cardSleeping)
        val textSleep: TextView = item.findViewById(R.id.sleepingName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_sleeping, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textSleep.text = data.name


        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
