package com.example.quiz_app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.quiz_app.Constants.CORRECT_ANSWERS_NUMBER
import com.example.quiz_app.Constants.NUMBER_OF_ALL_QUESTIONS
import com.example.quiz_app.Constants.PLAYER_NAME
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    val allQuestions = Constants.getQuestions()
    var currentQuestion = 1
    var chosenAnswer = 0
    var correctAnswers = 0
    var playerName = ""


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        playerName = intent.getStringExtra(PLAYER_NAME).toString()
        initObjects()
        viewQuestion()
    }

    private fun initObjects() {
        firstAnswer.setOnClickListener(this)
        secondAnswer.setOnClickListener(this)
        thirdAnswer.setOnClickListener(this)
        fourthAnswer.setOnClickListener(this)
        submitButton.setOnClickListener(this)
    }

    private fun viewQuestion() {
        val question = allQuestions[currentQuestion - 1]
        questionTV.text = question.question
        imageIV.setImageResource(question.picture)
        progressBar.progress = currentQuestion
        progressInNumber.text = currentQuestion.toString()

        firstAnswer.text = question.options[0]
        secondAnswer.text = question.options[1]
        thirdAnswer.text = question.options[2]
        fourthAnswer.text = question.options[3]
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.firstAnswer -> {
                setAnswerViewSelected(firstAnswer)
                chosenAnswer = 1
            }
            R.id.secondAnswer -> {
                setAnswerViewSelected(secondAnswer)
                chosenAnswer = 2
            }
            R.id.thirdAnswer -> {
                setAnswerViewSelected(thirdAnswer)
                chosenAnswer = 3
            }
            R.id.fourthAnswer -> {
                setAnswerViewSelected(fourthAnswer)
                chosenAnswer = 4
            }
            R.id.submitButton -> {
                onSubmitClicked()
            }
        }
    }

    private fun onSubmitClicked() {
        if (chosenAnswer == 0) {
            return
        }
        disableAllAnswers()

        val correctOption = allQuestions[currentQuestion - 1].correctOption
        when (correctOption) {
            1 -> setAnswerViewCorrect(firstAnswer)
            2 -> setAnswerViewCorrect(secondAnswer)
            3 -> setAnswerViewCorrect(thirdAnswer)
            4 -> setAnswerViewCorrect(fourthAnswer)
        }

        if (correctOption == chosenAnswer) {
            correctAnswers++
        } else {
            when (chosenAnswer) {
                1 -> setAnswerViewWrong(firstAnswer)
                2 -> setAnswerViewWrong(secondAnswer)
                3 -> setAnswerViewWrong(thirdAnswer)
                4 -> setAnswerViewWrong(fourthAnswer)
            }
        }

        if (currentQuestion == allQuestions.size) {
            showFinishButton()
            return
        }
        showNextAnswerButton()
    }

    private fun disableAllAnswers() {
        firstAnswer.isEnabled = false
        secondAnswer.isEnabled = false
        thirdAnswer.isEnabled = false
        fourthAnswer.isEnabled = false
    }

    private fun enableAllAnswers() {
        firstAnswer.isEnabled = true
        secondAnswer.isEnabled = true
        thirdAnswer.isEnabled = true
        fourthAnswer.isEnabled = true
    }

    private fun onNextQuestionClicked() {
        chosenAnswer = 0
        currentQuestion++
        viewQuestion()
        enableAllAnswers()
        resetAnswersToDefaultView()
        showSubmitButton()
    }

    private fun onFinishClicked() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(CORRECT_ANSWERS_NUMBER, correctAnswers)
        intent.putExtra(NUMBER_OF_ALL_QUESTIONS, allQuestions.size)
        intent.putExtra(PLAYER_NAME, playerName)
        startActivity(intent)
        finish()
    }

    private fun resetAnswersToDefaultView() {
        setAnswerViewDefault(firstAnswer)
        setAnswerViewDefault(secondAnswer)
        setAnswerViewDefault(thirdAnswer)
        setAnswerViewDefault(fourthAnswer)
    }

    private fun setAnswerViewDefault(v: TextView) {
        v.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.default_answer_background,
            theme
        )
    }

    private fun setAnswerViewSelected(v: TextView) {
        resetAnswersToDefaultView()
        v.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.selected_answer_shape,
            theme
        )
    }

    private fun setAnswerViewCorrect(v: TextView) {
        v.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.correct_answer_shape,
            theme
        )
    }

    private fun setAnswerViewWrong(v: TextView) {
        v.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.wrong_answer_shape,
            theme
        )
    }

    private fun showNextAnswerButton() {
        submitButton.text = resources.getString(R.string.next_question_text)
        submitButton.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.next_question_shape,
            theme
        )
        submitButton.setOnClickListener {
            onNextQuestionClicked()
        }
    }

    private fun showSubmitButton() {
        submitButton.text = resources.getString(R.string.submit_text)
        submitButton.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.submit_button_shape,
            theme
        )
        submitButton.setOnClickListener {
            onSubmitClicked()
        }
    }

    private fun showFinishButton() {
        submitButton.text = resources.getString(R.string.finish_text)
        submitButton.background = ResourcesCompat.getDrawable(
            resources,
            R.drawable.next_question_shape,
            theme
        )
        submitButton.setOnClickListener {
            onFinishClicked()
        }
    }

}