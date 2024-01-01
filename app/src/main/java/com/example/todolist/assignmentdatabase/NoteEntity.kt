package com.example.todolist.assignmentdatabase
import androidx.room.Entity
import androidx.room.PrimaryKey

//Open object for the parameters the 'Add Assignment' will need
//PrimaryKey will be used to identify if completed / 0=not / 1=done

@Entity("notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
