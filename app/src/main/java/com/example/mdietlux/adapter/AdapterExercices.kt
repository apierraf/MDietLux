package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.exercices.DataExercices
import com.example.mdietlux.data.model.habits.DataHabit
import com.example.mdietlux.utils.ItemClick

class AdapterExercices (
    val context: Context, val dataList: List<DataExercices>, val itemClick: ItemClick
) : RecyclerView.Adapter<AdapterExercices.ViewHolder>() {


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardExercices: CardView = item.findViewById(R.id.cardExercices)
        val textExercices: TextView = item.findViewById(R.id.exercicesName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_exercices, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textExercices.text = data.name


        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}