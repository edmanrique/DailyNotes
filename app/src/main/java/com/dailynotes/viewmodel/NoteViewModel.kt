package com.dailynotes.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.dailynotes.data.NoteDatabase
import com.dailynotes.model.Note
import com.dailynotes.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Note>>
    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        getAllData = repository.getAllData
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {repository.addNote(note)}
    }

    fun updateNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {repository.updateNote(note)}
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {repository.deleteNote(note)}
    }
}