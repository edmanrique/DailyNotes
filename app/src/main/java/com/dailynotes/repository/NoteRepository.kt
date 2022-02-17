package com.dailynotes.repository

import com.dailynotes.data.NoteDao
import androidx.lifecycle.LiveData
import com.dailynotes.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    val getAllData: LiveData<List<Note>> = noteDao.getAllData()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }
}