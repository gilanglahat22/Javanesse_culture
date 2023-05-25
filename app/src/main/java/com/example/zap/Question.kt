package com.example.zap

data class Question (
    val questionId: Int,
    val question: String,
    val category: String,
    val categoryImage: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int,
    val srcBackground: String
)