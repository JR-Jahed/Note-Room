package com.example.noteroom.db_logged_in

import android.app.Application
import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val repository = UserRepository(application)

    fun insert(user : UserLoggedIn) {
        removeUser()
        SystemClock.sleep(500)
        viewModelScope.launch {
            repository.insert(user)
        }
    }
    fun update(user : UserLoggedIn) {
        viewModelScope.launch {
            repository.update(user)
        }
    }
    fun delete(user : UserLoggedIn) {
        viewModelScope.launch {
            repository.delete(user)
        }
    }

    var userLoggedIn = MutableLiveData<UserLoggedIn>()

    fun getUser() = CoroutineScope(IO).launch {
        val x = repository.getUser()
        withContext(Dispatchers.Main) {
            userLoggedIn.postValue(x)
            Log.d("jahed", "line 42  $userLoggedIn")
        }
    }
    fun removeUser() = CoroutineScope(IO).launch {
        repository.removeUser()
    }
}