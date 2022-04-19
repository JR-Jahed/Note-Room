package com.example.noteroom.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("select * from user_table where email = :email and password = :password")
    suspend fun getUser(email : String, password : String) : User

    @Query("select * from user_table where id = :id")
    suspend fun getUserById(id : Int) : User

    @Query("select * from user_table")
    suspend fun getAllUser() : List<User>

    @Query("delete from user_table where id = :id")
    suspend fun deleteById(id : Int)

}