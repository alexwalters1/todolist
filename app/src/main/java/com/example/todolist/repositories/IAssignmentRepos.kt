package com.example.todolist.repositories

import com.example.todolist.assignmentdatabase.AssignmentEntity
import kotlinx.coroutines.flow.Flow

interface IAssignmentRepos {
    suspend fun getAssignments():Flow<List<AssignmentEntity>>
    suspend fun addAssignments(assignmentEntity: AssignmentEntity)
    suspend fun updateAssignments(assignmentEntity: AssignmentEntity)
    suspend fun deleteAssignments(assignmentEntity: AssignmentEntity)
}