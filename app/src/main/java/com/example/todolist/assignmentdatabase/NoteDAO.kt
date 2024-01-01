package com.example.todolist.assignmentdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDAO {
    @Insert
    fun addNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM 'notes'")
    fun getNote():kotlinx.coroutines.flow.Flow<List<NoteEntity>>

    @Update
    fun updateNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

}