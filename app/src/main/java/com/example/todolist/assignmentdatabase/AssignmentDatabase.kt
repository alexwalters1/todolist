package com.example.todolist.assignmentdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AssignmentEntity::class], version = 2)
abstract class AssignmentDatabase:RoomDatabase() {
    abstract fun AssignmentDAO():AssignmentDAO
}