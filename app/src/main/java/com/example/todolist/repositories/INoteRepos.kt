package com.example.todolist.repositories

import com.example.todolist.assignmentdatabase.NoteEntity
import kotlinx.coroutines.flow.Flow

interface INoteRepos {
    suspend fun getNote():Flow<List<NoteEntity>>
    suspend fun addNote(noteEntity: NoteEntity)
    suspend fun updateNote(noteEntity: NoteEntity)
    suspend fun deleteNote(noteEntity: NoteEntity)
}