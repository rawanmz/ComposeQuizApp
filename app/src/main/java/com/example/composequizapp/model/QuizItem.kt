package com.example.composequizapp.model

data class QuizItem(
    val Id:Int,
    val question: String,
    val answersList: List<String>,
    val correctChoice: String,
    var isAnswerCorrect: Boolean = false
)