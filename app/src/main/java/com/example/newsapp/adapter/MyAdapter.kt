package com.example.newsapp.adapter



import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.R
import com.example.newsapp.models.Article


class MyAdapter(private val context: Context, private val itemList: ArrayList<Article>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        //this text added to test github

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rcv_one_ele, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.title.text = item.title
        holder.desp.text = item.description
        holder.imageView.load(item.urlToImage)

    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val desp: TextView = itemView.findViewById(R.id.desp)

        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
