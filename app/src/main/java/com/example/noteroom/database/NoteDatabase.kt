package com.example.noteroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [User::class], version = 1)
@TypeConverters(Converter::class)

abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

    companion object {

        @Volatile
        private var instance : NoteDatabase ?= null

        fun getInstance(context: Context) : NoteDatabase {
            synchronized(this) {

                if(instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "note_database")
                        //.fallbackToDestructiveMigration()
                        //.addTypeConverter(converter)
                        .build()
                }

                return instance!!
            }
        }
    }

}