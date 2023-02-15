package com.example.gdsc;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Passlist::class], version = 1)
abstract class Employeedatabase:RoomDatabase(){

    abstract fun employeeDao():EmployeeDao


    companion object{

        @Volatile
        private var INSTANCE: Employeedatabase? = null

        fun getInstance(context: Context):Employeedatabase{

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Employeedatabase::class.java,
                        "employee_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
