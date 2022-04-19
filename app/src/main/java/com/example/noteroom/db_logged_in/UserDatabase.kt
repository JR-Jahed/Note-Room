package com.example.noteroom.db_logged_in

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserLoggedIn::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getDao() : UserDao

    companion object {

        private var instance : UserDatabase ?= null

        fun getDatabase(context : Context) : UserDatabase {
            synchronized(this) {

                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                    UserDatabase::class.java, "user_logged_in_db").build()
                }

                return instance!!
            }
        }

    }

}