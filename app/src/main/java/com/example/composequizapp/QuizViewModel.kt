package com.example.composequizapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composequizapp.model.QuizItem

class QuizViewModel : ViewModel() {

    var quizList: MutableList<QuizItem> = mutableListOf(
        QuizItem(
            1,
            "What is the capital city of Saudi Arabia",
            listOf<String>("Ryaidh", "Jeddah", "Makkah"),
            "Ryaidh"
        ),
        QuizItem(
            2,
            "What is color Black",
            listOf<String>("Orange", "Blue", "Black"),
            "Black"
        ),
        QuizItem(
            3,
            "What is your favourite color",
            listOf<String>("Purple", "Red", "Green"),
            "Green"
        ),
    )

    val score = mutableStateOf("")


    fun checkAnswer(quizItem: QuizItem, answer: String) {
        quizList = quizList.map {
            if (it.Id == quizItem.Id && answer == it.correctChoice) {
                it.copy(isAnswerCorrect = true)
            } else if (it.Id == quizItem.Id && answer != it.correctChoice) {
                it.copy(isAnswerCorrect = false)
            } else {
                it
            }
        }.toMutableList()
    }

    fun onSubmit() {
        val numOfCorrectAnswers = quizList.filter { it.isAnswerCorrect==true }.size
        score.value = "you got ${numOfCorrectAnswers} out of ${quizList.size}"
    }
}