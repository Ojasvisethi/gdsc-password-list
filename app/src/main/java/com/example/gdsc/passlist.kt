package com.example.gdsc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee-table")
data class Passlist(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val website: String?,
    val username:String?,
    val password:String?
    )