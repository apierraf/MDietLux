package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.energies.DataEnergies
import com.example.mdietlux.data.model.exercices.DataExercices
import com.example.mdietlux.utils.ItemClick

class EnergiesAdapter(
    val context: Context, val dataList: List<DataEnergies>, val itemClick: ItemClick
) : RecyclerView.Adapter<EnergiesAdapter.ViewHolder>() {


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardEnergies: CardView = item.findViewById(R.id.cardEnergies)
        val textEnergies: TextView = item.findViewById(R.id.energiesName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_energies, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textEnergies.text = data.name


        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}