package com.example.noteroom.database

import android.app.Application

class NoteRepository(application : Application) {

    private val noteDao = NoteDatabase.getInstance(application).noteDao()

    suspend fun insert(user: User) = noteDao.insert(user)

    suspend fun delete(user: User) = noteDao.delete(user)

    suspend fun update(user: User) = noteDao.update(user)

    suspend fun getAllUser() = noteDao.getAllUser()

    suspend fun getUser(email : String, password : String) = noteDao.getUser(email, password)

    suspend fun deleteById(id : Int) = noteDao.deleteById(id)
}