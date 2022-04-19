package com.example.noteroom.database

import android.app.Application
import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.noteroom.db_logged_in.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNoteViewModel(application: Application) : AndroidViewModel(application) {

    val repository = NoteRepository(application)

    fun update(user : User) = CoroutineScope(IO).launch {
        repository.update(user)
    }

    fun saveNote(id : Int, note: Note) = CoroutineScope(IO).launch {
        val cur_user = repository.getUserById(id)

        Log.d("jahed", "line 44  $cur_user")

        var notes  = cur_user.notes

        val converter = Converter()

        var notesList = converter.fromStringToList(notes)
        notesList.add(note)

        cur_user.notes = converter.fromListToString(notesList)
        update(cur_user)

    }

}