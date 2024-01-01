package com.example.todolist.repositories

import com.example.todolist.assignmentdatabase.AssignmentDatabase
import com.example.todolist.assignmentdatabase.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepos(private val database: AssignmentDatabase):INoteRepos {
    private val dao = database.NoteDAO()

    override suspend fun getNote(): Flow<List<NoteEntity>> = dao.getNote()
    override suspend fun addNote(noteEntity: NoteEntity) = dao.addNote(noteEntity)
    override suspend fun updateNote(noteEntity: NoteEntity) = dao.updateNote(noteEntity)
    override suspend fun deleteNote(noteEntity: NoteEntity) = dao.deleteNote(noteEntity)
}