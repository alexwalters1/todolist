package com.example.todolist.repositories

import com.example.todolist.assignmentdatabase.AssignmentDatabase
import com.example.todolist.assignmentdatabase.AssignmentEntity
import kotlinx.coroutines.flow.Flow

class ReposImp(private val database: AssignmentDatabase):AssignmentRepos {
    private val dao = database.AssignmentDAO()

    override suspend fun getAssignments(): Flow<List<AssignmentEntity>> = dao.getAssignments()
    override suspend fun addAssignments(assignmentEntity: AssignmentEntity) = dao.addAssignment(assignmentEntity)
    override suspend fun updateAssignments(assignmentEntity: AssignmentEntity) = dao.updateAssignments(assignmentEntity)
    override suspend fun deleteAssignments(assignmentEntity: AssignmentEntity) = dao.deleteAssignments(assignmentEntity)
}