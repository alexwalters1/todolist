package com.example.todolist.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.assignmentdatabase.NoteEntity
import com.example.todolist.repositories.INoteRepos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NoteViewModel:ViewModel(), KoinComponent{
    private val repo: INoteRepos by inject()

    private val _notes:MutableStateFlow<List<NoteEntity>> = MutableStateFlow(emptyList())
    val notes = _notes.asStateFlow()

    init {
        getNotes()
    }

    private fun getNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getNote().collect{data ->
                _notes.update { data }
            }
        }
    }

    fun updateNotes(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateNote(noteEntity)
        }
    }

    fun deleteNotes(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteNote(noteEntity)
        }
    }

    fun addNotes(noteEntity: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addNote(noteEntity)
        }
    }
}