package com.example.todolist.assignmentdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AssignmentDAO {
    @Insert
    fun addAssignment(assignmentEntity: AssignmentEntity)

    @Query("SELECT * FROM 'assignments'")
    fun getAssignments():kotlinx.coroutines.flow.Flow<List<AssignmentEntity>>

    @Update
    fun updateAssignments(assignmentEntity: AssignmentEntity)

    @Delete
    fun deleteAssignments(assignmentEntity: AssignmentEntity)

}