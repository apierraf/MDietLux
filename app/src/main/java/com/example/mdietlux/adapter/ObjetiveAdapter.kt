package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.objetives.DataObjetive
import com.example.mdietlux.utils.ItemClick

class ObjetiveAdapter(
    val context: Context,
    val dataList: List<DataObjetive>,
    val itemClick: ItemClick
) : RecyclerView.Adapter<ObjetiveAdapter.ViewHolder>(){


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val cardOjetive: CardView = item.findViewById(R.id.cardObjetive)
        val textObjetive: TextView = item.findViewById(R.id.objetiveName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_objetives, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.textObjetive.text = data.name


        holder.itemView.setOnClickListener {
            itemClick.clicked(position)
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}