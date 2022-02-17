package com.dailynotes.model

import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo(name="fecha")
    val fecha: String,

    @ColumnInfo(name="bueno")
    val bueno: String,

    @ColumnInfo(name="descripcion")
    val descripcion: String
) : Parcelable
