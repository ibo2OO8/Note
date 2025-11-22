package com.ibrohimapk3.notest1.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.notest1.R

class MyAdapter(var callBack: CallBack): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var list : List<ItemsData> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context)
        .inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.tvTitle.text = item.title
        holder.itemView.setOnClickListener {
            callBack.onItemClick(item)
        }
        holder.btnDelete.setOnClickListener {
            callBack.deleteItem(item.title.toString())
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val tvTitle : TextView = itemView.findViewById(R.id.tv_title)
        val btnDelete: Button = itemView.findViewById(R.id.btn_delete)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<ItemsData>) {
        list = newList
        notifyDataSetChanged()
    }
}