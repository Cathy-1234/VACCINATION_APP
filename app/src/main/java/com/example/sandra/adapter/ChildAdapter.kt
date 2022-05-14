package com.example.sandra.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandra.Child
import com.example.sandra.R

class ChildAdapter(val list:ArrayList<Child>):RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {
    val context: Context ?= null
    val x = list
    class ChildViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.child_list, null)
        return ChildViewHolder(v)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.name)
        name.text = x[position].name.first().toString()
    }

    override fun getItemCount(): Int {
       return x.size
    }

}