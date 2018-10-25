package com.android.lab3.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.news_layout.view.*
import android.widget.ImageView
import com.android.lab3.Model.NewsModel
import com.android.lab3.R

class NewsAdapter(var persons:List<NewsModel>):RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = persons[position].title
        holder.date.text = persons[position].date
        holder.image.setImageResource(persons[position].getImageUrl())
    }

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(holder.context)
        val view = inflater.inflate(R.layout.news_layout, holder, false)
        return ViewHolder(view)
    }
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.primary_text
        var date: TextView  = itemView.sub_text
        var image: ImageView = itemView.media_image

    }
}