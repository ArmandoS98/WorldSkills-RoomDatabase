package com.aesc.roomdatabase.repository

import com.aesc.roomdatabase.database.NoteDAO
import com.aesc.roomdatabase.models.Note

class Repository(var noteDAO: NoteDAO) {
    suspend fun addNote(note: Note) = noteDAO.addNote(note)
    suspend fun updateNote(note: Note) = noteDAO.updateNote(note)
    suspend fun delteNote(note: Note) = noteDAO.deleteNote(note)
    fun getNotes() = noteDAO.getNotes()
}