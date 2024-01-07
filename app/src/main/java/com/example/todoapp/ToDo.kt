package com.example.todoapp

data class ToDo(
    val title: String,
    var isChecked: Boolean = false
)