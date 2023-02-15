package com.example.gdsc

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gdsc.databinding.AddDataBinding
import com.example.gdsc.databinding.Passwordscreen2Binding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    private var binding: Passwordscreen2Binding? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Passwordscreen2Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        var weblist : RecyclerView = findViewById(R.id.recycle)
        val employeeDao = (application as EmployeeApp).db.employeeDao()
        var btn : ImageView = findViewById(R.id.imageView)
        btn.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch {
            employeeDao.fetchAlldata().collect{
                val list = ArrayList(it)
                setupListofDatainRecyclerView(list,employeeDao)
            }
        }

    }
    private fun setupListofDatainRecyclerView(employeesList: ArrayList<Passlist>,
    employeeDao: EmployeeDao){
        if(employeesList.isNotEmpty()){
            val itemAdapter = ItemAdapter(employeesList)
            binding?.recycle?.layoutManager = LinearLayoutManager(this)
            binding?.recycle?.adapter = itemAdapter
            binding?.recycle?.visibility = View.VISIBLE
        }
    }

}