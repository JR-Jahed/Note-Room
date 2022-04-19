package com.example.noteroom.db_logged_in

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName  = "cur_user")
data class UserLoggedIn(

    @PrimaryKey
    var id : Int = 0
)
