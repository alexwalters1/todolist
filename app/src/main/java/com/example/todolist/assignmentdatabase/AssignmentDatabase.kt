package com.example.todolist.assignmentdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AssignmentEntity::class, NoteEntity::class], version = 3)
abstract class AssignmentDatabase:RoomDatabase() {
    abstract fun AssignmentDAO():AssignmentDAO
    abstract fun NoteDAO():NoteDAO
}