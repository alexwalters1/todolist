package com.example.todolist

import android.app.Application
import androidx.room.Room
import com.example.todolist.assignmentdatabase.AssignmentDatabase
import com.example.todolist.repositories.AssignmentRepos
import com.example.todolist.repositories.IAssignmentRepos
import com.example.todolist.repositories.INoteRepos
import com.example.todolist.repositories.NoteRepos
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module


class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module {
                single {
                    Room
                        .databaseBuilder(this@KoinApp, AssignmentDatabase::class.java, name = "db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                single {
                    AssignmentRepos(database = get())
                } bind IAssignmentRepos ::class
                single {
                    NoteRepos(database = get())
                } bind INoteRepos ::class
            })
        }
    }
}