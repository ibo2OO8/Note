package com.ibrohimapk3.notest1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items") // название моей таблици
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo(name = "title")
    var title : String = "",

    @ColumnInfo(name = "content")
    var content : String = ""
)
