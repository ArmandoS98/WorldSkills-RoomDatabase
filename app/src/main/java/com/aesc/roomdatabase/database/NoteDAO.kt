package com.aesc.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aesc.roomdatabase.models.Note

@Dao
interface NoteDAO {
    //CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>
}