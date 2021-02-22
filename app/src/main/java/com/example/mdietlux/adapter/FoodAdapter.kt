package com.example.mdietlux.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mdietlux.R
import com.example.mdietlux.data.model.diet.Food


class FoodAdapter(context: Context, chapters: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.CustomViewHolder>() {

    private val context: Context = context
    private val chapters: ArrayList<Food> = chapters
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = inflater.inflate(R.layout.item_square_card, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val chapter: Food = chapters[position]

        holder.tvChapterType.text = chapter.chapterType

        Glide.with(context)
                .load("https://mdietlux.com/" + chapter.imageUrl)
                .centerInside()
                .override(250)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivChapter)

        holder.tvChapterName.text = chapter.chapterName
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivChapter: ImageView = itemView.findViewById(R.id.icon) as ImageView
        var tvChapterName: TextView = itemView.findViewById(R.id.text1)
        var tvChapterType: TextView = itemView.findViewById(R.id.typefood)

    }

}