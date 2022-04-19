package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.noteroom.database.AddNoteViewModel
import com.example.noteroom.database.Note
import com.example.noteroom.database.User
import com.example.noteroom.databinding.ActivityAddNoteBinding
import com.example.noteroom.db_logged_in.UserViewModel
import kotlin.properties.Delegates

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddNoteBinding
    private lateinit var viewModel : AddNoteViewModel
    private lateinit var userViewModel : UserViewModel
    private var id : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.userLoggedIn.observe(this) {
            Log.d("jahed", "line 31   $it")
            id = it.id
        }

        userViewModel.getUser()

        binding.btnSave.setOnClickListener {
            Log.d("jahed", "addnoteacti  line 38  $id")

            viewModel.saveNote(id, Note(binding.etNoteTitle.text.toString(), binding.etNoteContent.text.toString()))

            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}