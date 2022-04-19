package com.example.noteroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteroom.databinding.ActivityShowNoteBinding

class ShowNoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShowNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShowNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.extras?.getString("noteTitle")
        val content = intent.extras?.getString("noteContent")

        binding.tvNoteTitle.text = title
        binding.tvNoteContent.text = content
    }
}