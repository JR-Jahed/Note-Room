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

    fun removeNote(userId : Int, noteIdx : Int) = CoroutineScope(IO).launch {
        val user = repository.getUserById(userId)

        val converter = Converter()

        var notesList = converter.fromStringToList(user.notes)
        notesList.removeAt(noteIdx)

        user.notes = converter.fromListToString(notesList)

        repository.update(user)

        withContext(Dispatchers.Main) {
            notes.postValue(notesList)
        }
    }
}
