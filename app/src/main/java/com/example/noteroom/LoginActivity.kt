package com.example.noteroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.noteroom.database.LoginViewModel
import com.example.noteroom.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.user.observe(this) {
            startActivity(Intent(this, HomeActivity::class.java))
            finishAffinity()
        }

        binding.btnLogin.setOnClickListener {
            viewModel.getUser(binding.etEmail.text.toString(), binding.etPass.text.toString())
        }
    }
}