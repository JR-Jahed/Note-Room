package com.example.noteroom.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    val repository = NoteRepository(application)

    var notes = MutableLiveData<MutableList<Note>>()

    fun getNotes(id : Int) = CoroutineScope(IO).launch {

        val user = repository.getUserById(id)

        val converter = Converter()

        val notesList = converter.fromStringToList(user.notes)

        withContext(Dispatchers.Main) {
            notes.postValue(notesList)
        }
    }
}