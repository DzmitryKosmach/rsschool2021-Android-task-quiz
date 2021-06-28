package com.rsschool.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class QuizViewModel(application: Application) : AndroidViewModel(application) {
    private val appResources = getApplication<Application>().resources
    private val questions: Array<String>
    private val rightAnswers: Array<String>
    lateinit var answers: Array<String>
    lateinit var selectedOptions: Array<Int>

    init {
        resetQuiz()
        questions = arrayOf(
            appResources.getString(R.string.question1_text),
            appResources.getString(R.string.question2_text),
            appResources.getString(R.string.question3_text),
            appResources.getString(R.string.question4_text),
            appResources.getString(R.string.question5_text)
        )
        rightAnswers = arrayOf(
            appResources.getString(R.string.question1_option1),
            appResources.getString(R.string.question2_option2),
            appResources.getString(R.string.question3_option2),
            appResources.getString(R.string.question4_option2),
            appResources.getString(R.string.question5_option3)
        )
    }

    fun checkResult(): String {
        var countRightAnswers = 0
        for ((index, value) in rightAnswers.withIndex()) {
            if (answers[index] == value) ++countRightAnswers
        }
        return "Your result: ${countRightAnswers * 20}%\n"
    }

    fun resetQuiz() {
        answers = Array(5) { "answer" }
        selectedOptions = Array(5) { -1 }
    }

    fun getResultQuiz(): String {
        val resultStringBuilder = StringBuilder("")
        questions.forEachIndexed { index, question ->
            resultStringBuilder.append("${index+1}) ${question}\nAnswer: ${answers[index]}\n\n")
        }
        return "${checkResult()}\n $resultStringBuilder"
    }
}