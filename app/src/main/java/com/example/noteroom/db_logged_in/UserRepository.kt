package com.example.noteroom.db_logged_in

import android.app.Application

class UserRepository(application: Application) {

    val userDao = UserDatabase.getDatabase(application).getDao()

    suspend fun insert(user : UserLoggedIn) = userDao.insert(user)

    suspend fun update(user : UserLoggedIn) = userDao.update(user)

    suspend fun delete(user : UserLoggedIn) = userDao.delete(user)

    suspend fun getUser() = userDao.getUser()

    suspend fun removeUser() = userDao.removeUser()
}