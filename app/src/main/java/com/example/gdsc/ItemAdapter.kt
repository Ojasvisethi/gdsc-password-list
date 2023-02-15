package com.example.gdsc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc.databinding.ActivityMain2Binding

class ItemAdapter(private val items: ArrayList<Passlist>
//                  private val updateListener:(id:Int)->Unit,

):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(binding: ActivityMain2Binding) : RecyclerView.ViewHolder(binding.root){
        val llmain = binding.llmain
        val website = binding.website
        val username = binding.username
        val password = binding.password
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ActivityMain2Binding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = items[position]

        holder.website.text = item.website
        holder.username.text =items[position].username
        holder.password.text = items[position].password
    }
}