package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.packe.PackeListData
import com.example.mdietlux.utils.ItemClick

class PackeAdapter(
    val context: Context,
    val dataList: List<PackeListData>,
    val itemClick: ItemClick
) : RecyclerView.Adapter<PackeAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val textPrice : TextView = item.findViewById(R.id.price)
        val currency : TextView = item.findViewById(R.id.currency)
        val name : TextView = item.findViewById(R.id.name)
        val promotion: TextView = item.findViewById(R.id.promotion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_packe, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.textPrice.text = data.price.toString()
        holder.currency.text = data.currency
        holder.name.text = data.name
        holder.promotion.text = data.discountPromotion

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}