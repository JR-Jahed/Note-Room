package com.example.noteroom

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteroom.adapters.UserRecyclerViewAdapter
import com.example.noteroom.database.MainViewModel
import com.example.noteroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : UserRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModelObserver()
        viewModel.getAllUser()

        binding.fabAddUser.setOnClickListener {
            startActivity(Intent(this, AddUserActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun populateRecyclerView() {
        adapter = UserRecyclerViewAdapter()
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = LinearLayoutManager(this)
    }

    fun viewModelObserver() {
        viewModel.userList.observe(this) {
            adapter.setData(ArrayList(it))
            adapter.notifyDataSetChanged()
        }
    }
}

















