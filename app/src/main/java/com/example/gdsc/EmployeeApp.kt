package com.example.gdsc

import android.app.Application

class EmployeeApp:Application() {
    val db by lazy {
        Employeedatabase.getInstance(this)
    }
}