package com.example.noteroom.db_logged_in

import androidx.room.*

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user : UserLoggedIn)

    @Update
    suspend fun update(user : UserLoggedIn)

    @Delete
    suspend fun delete(user : UserLoggedIn)

    @Query("select * from cur_user")
    suspend fun getUser() : UserLoggedIn

    @Query("delete from cur_user")
    suspend fun removeUser()
}