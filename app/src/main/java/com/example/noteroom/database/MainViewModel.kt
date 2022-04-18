package com.example.noteroom.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repository = NoteRepository(application)

    fun insert(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    var userList = MutableLiveData<List<User>>()

    fun getAllUser() = CoroutineScope(IO).launch {
        val x = repository.getAllUser()

        withContext(Dispatchers.Main) {
            userList.postValue(x)
        }
    }

    fun deleteById(id : Int) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }
}

















