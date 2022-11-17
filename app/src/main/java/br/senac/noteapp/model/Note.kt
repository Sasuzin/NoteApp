package br.senac.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    //@ColumnInfo(name = "DESCRIPTION")
    var desc: String
    )
