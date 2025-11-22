package com.ibrohimapk3.notest1.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insertItem(item: NoteEntity)

    @Query("SELECT * From items")
    fun getAllItems() : LiveData<List<NoteEntity>>

    @Query("Delete from items where title = :title")
    suspend fun deleteItemByTitle(title:String)
}