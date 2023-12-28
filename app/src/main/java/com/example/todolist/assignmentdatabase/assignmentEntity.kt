package com.example.todolist.assignmentdatabase
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

//Open object for the parameters the 'Add Assignment' will need
//PrimaryKey will be used to identify if completed / 0=not / 1=done

@Entity("assignments")
data class AssignmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("Assignment")
    val title: String,
    @ColumnInfo("Description")
    val desc:String,
    @ColumnInfo("Due Date")
    val date: String,
    @ColumnInfo("DateAdded")
    val added: Long = System.currentTimeMillis(),
    @ColumnInfo("done")
    val done:Boolean = false
)

val AssignmentEntity.addDate:String get() = SimpleDateFormat("dd/MM/yyyy").format(Date(added))

