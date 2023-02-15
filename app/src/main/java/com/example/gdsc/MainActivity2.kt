package com.example.gdsc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.gdsc.databinding.ActivityMainBinding
import com.example.gdsc.databinding.AddDataBinding
import kotlinx.coroutines.launch
import java.util.zip.Inflater

class MainActivity2 : AppCompatActivity() {
    private var binding: AddDataBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddDataBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val employeeDao = (application as EmployeeApp).db.employeeDao()
        binding?.button?.setOnClickListener {
            addrecord(employeeDao)
            var intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }

    }

    fun addrecord(employeeDao: EmployeeDao){
        val web = "website:" + binding?.textView?.text.toString()
        val name = "username:"+binding?.textView2?.text.toString()
        val pass = "password:"+binding?.textView3?.text.toString()

        lifecycleScope.launch {
            employeeDao.insert(Passlist(website = web, username = name, password = pass))
            binding?.textView?.text?.clear()
            binding?.textView2?.text?.clear()
            binding?.textView3?.text?.clear()
        }
    }
}