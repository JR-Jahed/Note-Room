package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteroom.adapters.NoteRecyclerViewAdapter
import com.example.noteroom.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var adapter: NoteRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateRecyclerView()

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }

    private fun populateRecyclerView() {
        adapter = NoteRecyclerViewAdapter()
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = LinearLayoutManager(this)
    }

}