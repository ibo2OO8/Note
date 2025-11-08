package com.ibrohimapk3.notest1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): NoteDao
    companion object {
        fun createDb(context: Context): MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "Note Test"
            ).fallbackToDestructiveMigration()
                .build()
        }
    }
}
