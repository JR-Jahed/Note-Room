package com.example.noteroom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteroom.database.User
import com.example.noteroom.databinding.RvListUserBinding

class UserRecyclerViewAdapter : RecyclerView.Adapter<UserRecyclerViewAdapter.MyViewHolder>() {

    var data = ArrayList<User>()

    @JvmName("setData1")
    fun setData(data : ArrayList<User>) {
        this.data = data
    }

    inner class MyViewHolder(val binding : RvListUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position : Int) {
            binding.tvId.text = data.get(position).id.toString()
            binding.tvName.text = data.get(position).name
            binding.tvEmail.text = data.get(position).email
            binding.tvPass.text = data.get(position).password
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvListUserBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

//    interface ClickListener {
//
//    }
}