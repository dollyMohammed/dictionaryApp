package com.example.dectionaryapp.Feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dectionaryapp.Feature_dictionary.data.local.entry.WordInfoEntity
import retrofit2.Converter

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converts::class)
abstract  class WordInfoDatabase : RoomDatabase() {
    abstract val dao:WordInfoDao
}