package com.example.noteroom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteroom.database.Note
import com.example.noteroom.databinding.RvListNoteBinding

class NoteRecyclerViewAdapter : RecyclerView.Adapter<NoteRecyclerViewAdapter.MyViewHolder>() {

    var notes = mutableListOf<Note>()
    @JvmName("setNotes1")
    fun setNotes(notes : MutableList<Note>) {
        this.notes = notes
    }

    private var listener : ClickListener ?= null

    fun setListener(_listener : ClickListener) {
        listener = _listener
    }

    inner class MyViewHolder(val binding : RvListNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position : Int) {
            binding.tvNote.text = "Note: ${position + 1}"
            binding.tvNoteTitle.text = notes.get(position).title

            binding.icDel.setOnClickListener {
                listener?.onRemoveButtonClicked(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvListNoteBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)

        holder.binding.mcv.setOnClickListener {
            listener?.onNoteClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    interface ClickListener {
        fun onRemoveButtonClicked(position: Int)
        fun onNoteClicked(position: Int)
    }
}