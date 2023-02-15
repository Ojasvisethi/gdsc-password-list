package com.example.gdsc

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insert(passlists : Passlist)

    @Update
    suspend fun update(passlists: Passlist)

    @Delete
    suspend fun delete(passlists: Passlist)

    @Query("SELECT * FROM `employee-table`")
    fun fetchAlldata():Flow<List<Passlist>>

}