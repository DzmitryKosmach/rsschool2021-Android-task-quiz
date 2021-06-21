package com.rsschool.quiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val resApp = App().resourcesApp
    val answers = Array(5, { "answer" })

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
}