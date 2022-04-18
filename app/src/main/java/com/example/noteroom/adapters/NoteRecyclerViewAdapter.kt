package com.example.noteroom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteroom.database.Note
import com.example.noteroom.databinding.RvListNoteBinding

class NoteRecyclerViewAdapter : RecyclerView.Adapter<NoteRecyclerViewAdapter.MyViewHolder>() {

    var notes = ArrayList<Note>()
    @JvmName("setNotes1")
    fun setNotes(notes : ArrayList<Note>) {
        this.notes = notes
    }

    inner class MyViewHolder(val binding : RvListNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position : Int) {
            binding.tvNote.text = binding.tvNote.text.toString() + "$position"
            binding.tvNoteTitle.text = notes.get(position).title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvListNoteBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}