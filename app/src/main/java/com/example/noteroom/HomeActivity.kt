package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteroom.adapters.NoteRecyclerViewAdapter
import com.example.noteroom.databinding.ActivityHomeBinding
import com.example.noteroom.db_logged_in.UserViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var adapter : NoteRecyclerViewAdapter
    private lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateRecyclerView()

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun populateRecyclerView() {
        adapter = NoteRecyclerViewAdapter()
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = LinearLayoutManager(this)
    }

}