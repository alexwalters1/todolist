package com.example.todolist.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.assignmentdatabase.AssignmentEntity
import com.example.todolist.repositories.IAssignmentRepos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel:ViewModel(), KoinComponent{
    private val repo: IAssignmentRepos by inject()

    private val _assignments:MutableStateFlow<List<AssignmentEntity>> = MutableStateFlow(emptyList())
    val assignments = _assignments.asStateFlow()

    init {
        getAssignments()
    }

    private fun getAssignments(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getAssignments().collect{data ->
                _assignments.update { data }
            }
        }
    }

    fun updateAssignments(assignmentEntity: AssignmentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateAssignments(assignmentEntity)
        }
    }

    fun deleteAssignments(assignmentEntity: AssignmentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteAssignments(assignmentEntity)
        }
    }

    fun addAssignments(assignmentEntity: AssignmentEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addAssignments(assignmentEntity)
        }
    }
}