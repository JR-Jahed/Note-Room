package com.example.noteroom.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
class Converter {

    @TypeConverter
    fun fromListToString(list: MutableList<Note>): String {
        val gson = Gson()

        val jsonString = gson.toJson(list)
        return jsonString
    }

    @TypeConverter
    fun fromStringToList(st: String): MutableList<Note> {
        val gson = Gson()

        var jsonString = st

        if(jsonString == "") {
            jsonString = gson.toJson(mutableListOf<Note>())
        }

        val listType : Type = object : TypeToken<ArrayList<Note?>?>() {}.type

        return gson.fromJson(jsonString, listType)
    }

}