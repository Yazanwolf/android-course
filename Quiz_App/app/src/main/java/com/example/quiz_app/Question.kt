package com.example.quiz_app

data class Question(
    val id: Int,
    val picture: Int,
    val question: String,
    val options: ArrayList<String>,
    val correctOption: Int
)