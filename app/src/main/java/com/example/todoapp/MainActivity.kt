package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    private lateinit var todoAdapter: ToDoAdapter
    private lateinit var rvTodoItems: RecyclerView
    private lateinit var btnAddTodo: Button
    private lateinit var etTodoTitle: EditText
    private lateinit var btnDeleteDoneTodos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = ToDoAdapter(mutableListOf())
        rvTodoItems = findViewById(R.id.btnAddToDo)
        etTodoTitle = findViewById(R.id.etToDoTitle)
        btnDeleteDoneTodos = findViewById(R.id.etToDoTitle)
        (R.id.btnDeleteDoneToDos)

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
           val todoTitle = etTodoTitle.text.toString()
           if(todoTitle.isNotEmpty()) {
               val todo = ToDo(todoTitle)
               todoAdapter.addTodo(todo)
               etTodoTitle.text.clear()
           }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}