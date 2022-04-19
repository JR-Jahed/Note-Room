package com.example.noteroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int = 0,

    @ColumnInfo(name = "name")
    var name : String = "",

    @ColumnInfo(name = "email")
    var email : String = "",

    @ColumnInfo(name = "password")
    var password : String = "",

    @ColumnInfo(name = "note")
    var notes : String = ""
)
