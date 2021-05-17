package com.example.tester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())
        rvMedevac.adapter = todoAdapter
        rvMedevac.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val todoTitle = etMedevac.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = medaData(todoTitle)
                todoAdapter.addTodo(todo)
                etMedevac.text.clear()
            }
        }
        btnDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}