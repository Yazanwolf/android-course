package com.example.quiz_app

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    val allQuestions = QuestionConstants.getQuestions()
    var currentQuestion = 1
    var chosenAnswer = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        viewQuestion()

        firstAnswer.setOnClickListener { view ->
            Toast.makeText(view.context, "First answer is chosen", Toast.LENGTH_SHORT).show()
            chosenAnswer = 1
        }

        secondAnswer.setOnClickListener { view ->
            Toast.makeText(view.context, "Second answer is chosen", Toast.LENGTH_SHORT).show()
            chosenAnswer = 2
        }

        thirdAnswer.setOnClickListener { view ->
            Toast.makeText(view.context, "Third answer is chosen", Toast.LENGTH_SHORT).show()
            chosenAnswer = 3
        }

        fourthAnswer.setOnClickListener { view ->
            Toast.makeText(view.context, "Fourth answer is chosen", Toast.LENGTH_SHORT).show()
            chosenAnswer = 4
        }

        submitButton.setOnClickListener { view ->
            onSubmitClicked()
        }
    }

    private fun onSubmitClicked() {
        if (chosenAnswer == 0) {
            return
        }

        val correctOption = allQuestions.get(currentQuestion -1).correctOption
        if (correctOption == chosenAnswer) {
            when (chosenAnswer) {
                1 -> firstAnswer.background = ContextCompat.getDrawable(this, R.drawable.correct_answer_shape)
                2 -> secondAnswer.background = ContextCompat.getDrawable(this, R.drawable.correct_answer_shape)
                3 -> thirdAnswer.background = ContextCompat.getDrawable(this, R.drawable.correct_answer_shape)
                4 -> fourthAnswer.background = ContextCompat.getDrawable(this, R.drawable.correct_answer_shape)
            }
            submitButton.text = "Next Question"
            submitButton.setOnClickListener {
                onNextQuestionClicked()
            }
        } else {
            when (chosenAnswer) {
                1 -> firstAnswer.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_shape)
                2 -> secondAnswer.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_shape)
                3 -> thirdAnswer.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_shape)
                4 -> fourthAnswer.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_shape)
            }
        }
    }

    private fun onNextQuestionClicked() {
        chosenAnswer = 0
        currentQuestion++
        viewQuestion()
        submitButton.setText(R.string.submit_text)
        submitButton.setOnClickListener{onSubmitClicked()}
        firstAnswer.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)
        secondAnswer.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)
        thirdAnswer.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)
        fourthAnswer.background = ContextCompat.getDrawable(this, R.drawable.default_answer_background)
    }

    private fun viewQuestion() {

        val question = allQuestions[currentQuestion - 1]
        questionTV.text = question.question
        imageIV.setImageResource(question.picture)
        progressBar.progress = 5

        firstAnswer.text = question.options[0]
        secondAnswer.text = question.options[1]
        thirdAnswer.text = question.options[2]
        fourthAnswer.text = question.options[3]

    }

}