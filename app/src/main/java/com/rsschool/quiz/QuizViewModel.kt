package com.rsschool.quiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val resApp = App().resourcesApp
    lateinit var answers: Array<String>
    lateinit var selectedOptions: Array<Int>

    init {
        resetQuiz()
    }

    private val rightAnswers = arrayOf(
        "To be",
        "Burj Khalifa, Dubai",
        "Elephant",
        "Slack",
        "7"
    )

    fun checkResult(): String{
        var countRightAnswers = 0
        for ((index, value) in rightAnswers.withIndex()) {
            if (answers[index] ==  value) ++ countRightAnswers
        }
        return "Your result: ${countRightAnswers*20}%\n"
    }

    fun resetQuiz() {
        answers = Array(5) { "answer" }
        selectedOptions = Array(5) { -1 }
    }
}