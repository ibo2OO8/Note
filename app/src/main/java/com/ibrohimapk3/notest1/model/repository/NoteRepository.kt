package com.ibrohimapk3.notest1.model.repository

import androidx.lifecycle.LiveData
import com.ibrohimapk3.notest1.model.NoteDao
import com.ibrohimapk3.notest1.model.NoteEntity

class NoteRepository(private var dao: NoteDao) {
    suspend fun insertItem(item : NoteEntity){
        dao.insertItem(item)
    }
    fun getAllItem(): LiveData<List<NoteEntity>> {
        return dao.getAllItems()
    }
    fun deleteItemByTitle(title:String){
        dao.deleteItemByTitle(title)
    }

}