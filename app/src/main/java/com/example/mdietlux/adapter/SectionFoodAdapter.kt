package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mdietlux.R
import com.example.mdietlux.data.model.diet.SectionFood


class SectionFoodAdapter(subjects: ArrayList<SectionFood>, context: Context) :
    RecyclerView.Adapter<SectionFoodAdapter.ViewHolder>() {

    var subjects: ArrayList<SectionFood> = subjects
    private val context: Context = context
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = layoutInflater.inflate(R.layout.section_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.adapter = subjects[position].chapters?.let { FoodAdapter(context, it) }
        holder.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.setHasFixedSize(true)
        holder.tvHeading.text = subjects[position].subjectName
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.rvChapters)
        var tvHeading: TextView = itemView.findViewById(R.id.tvSubjectName)

    }

}