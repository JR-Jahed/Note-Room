package com.example.noteroom.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NoteRepository(application)

    val user = MutableLiveData<User>()

    fun getUser(email : String, password : String) = CoroutineScope(Dispatchers.IO).launch {
        val x = repository.getUser(email, password)
        Log.d("jahed", "loginviewmodel line 23 $x")
        if(x != null) {
            withContext(Dispatchers.Main) {
                user.postValue(x)
            }
        }
    }
}