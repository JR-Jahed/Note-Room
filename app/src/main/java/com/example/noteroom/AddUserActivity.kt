package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.noteroom.database.AddUserViewModel
import com.example.noteroom.database.User
import com.example.noteroom.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddUserBinding
    private lateinit var viewModel : AddUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AddUserViewModel::class.java]

        binding.btnSave.setOnClickListener {
            viewModel.insert(User(0, binding.etName.text.toString(), binding.etEmail.text.toString(), binding.etPass.text.toString()))
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}