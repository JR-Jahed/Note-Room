package com.example.noteroom.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AddUserViewModel(application: Application) : AndroidViewModel(application) {

    val repository = NoteRepository(application)

    fun insert(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }
}