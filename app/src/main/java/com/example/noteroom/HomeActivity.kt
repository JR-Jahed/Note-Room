package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteroom.adapters.NoteRecyclerViewAdapter
import com.example.noteroom.database.HomeViewModel
import com.example.noteroom.databinding.ActivityHomeBinding
import com.example.noteroom.db_logged_in.UserViewModel

class HomeActivity : AppCompatActivity(), NoteRecyclerViewAdapter.ClickListener {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var adapter : NoteRecyclerViewAdapter
    private lateinit var userViewModel : UserViewModel
    private lateinit var homeViewModel: HomeViewModel
    private var id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateRecyclerView()

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModelObserver()
        userViewModel.getUser()

        //homeViewModel.getNotes(id)

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
        adapter.setListener(this)
    }

    private fun viewModelObserver() {
        userViewModel.userLoggedIn.observe(this) {
            homeViewModel.getNotes(it.id)
            id = it.id
        }

        homeViewModel.notes.observe(this) { notes ->
            adapter.notes = notes
            adapter.notifyDataSetChanged()
        }
    }

    override fun onRemoveButtonClicked(position: Int) {
        homeViewModel.removeNote(id, position)

        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, adapter.notes.size)
    }

    override fun onNoteClicked(position: Int) {
        startActivity(Intent(this, ShowNoteActivity::class.java).putExtra("noteTitle", adapter.notes[position].title)
            .putExtra("noteContent", adapter.notes[position].content))
    }
}
