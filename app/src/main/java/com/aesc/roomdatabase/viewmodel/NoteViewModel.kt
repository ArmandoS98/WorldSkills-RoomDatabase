package com.aesc.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aesc.roomdatabase.database.NoteDatabase
import com.aesc.roomdatabase.models.Note
import com.aesc.roomdatabase.repository.Repository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application) : ViewModel() {
    //Hacemos intancia de nuestra base de datos
    private val noteDatabase = NoteDatabase.getDatabase(app).noteDao()
    private val repository: Repository

    val getNotes: LiveData<List<Note>>

    init {
        repository = Repository(noteDatabase)
        getNotes = repository.getNotes()
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.delteNote(note)
        }
    }
}