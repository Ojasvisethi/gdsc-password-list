package com.example.gdsc;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import androidx.recyclerview.widget.RecyclerView.ViewHolder


public class MyAdapter(var   items: ArrayList<Passlist>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_main2,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.websi.text = items[position].website
        holder.user.text =items[position].username
        holder.pass.text = items[position].password
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var websi = itemView.findViewById<TextView>(R.id.website)
        var user = itemView.findViewById<TextView>(R.id.username)
        var pass = itemView.findViewById<TextView>(R.id.password)
    }

}


