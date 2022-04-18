package com.example.noteroom.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val repository = NoteRepository(application)

    fun getNotes(user : User) {

    }
}