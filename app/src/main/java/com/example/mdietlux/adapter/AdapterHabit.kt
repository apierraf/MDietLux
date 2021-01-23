package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.habits.DataHabit
import com.example.mdietlux.utils.ItemClick

class AdapterHabit(
    val context: Context, val dataList: List<DataHabit>, val itemClick: ItemClick
) : RecyclerView.Adapter<AdapterHabit.ViewHolder>() {

    private var selectedItem = 0

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardHabit: CardView = item.findViewById(R.id.cardHabit)
        val textHabit: TextView = item.findViewById(R.id.habitName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_habit, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textHabit.text = data.name

        if (selectedItem == position) {
            holder.cardHabit.setCardBackgroundColor(context.resources.getColor(R.color.green_500))
        } else {
            holder.cardHabit.setCardBackgroundColor(context.resources.getColor(R.color.five))
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