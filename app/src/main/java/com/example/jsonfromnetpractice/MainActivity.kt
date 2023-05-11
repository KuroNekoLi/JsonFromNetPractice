package com.example.jsonfromnetpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this)[DataViewModel::class.java]
        viewModel.dataListLive.observe(this) {
            val dataAdapter = DataAdapter(it)
            recyclerView.adapter = dataAdapter
        }
        viewModel.dataListLive.value?:viewModel.fetchData()
    }
}