package com.dailynotes.data

import androidx.room.*
import androidx.lifecycle.LiveData
import com.dailynotes.model.Note

@Dao
interface NoteDao {
    @Query("Select * from Note")
    fun getAllData() : LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}