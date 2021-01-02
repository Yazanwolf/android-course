package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_app.Constants.CORRECT_ANSWERS_NUMBER
import com.example.quiz_app.Constants.NUMBER_OF_ALL_QUESTIONS
import com.example.quiz_app.Constants.PLAYER_NAME
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val playerName = intent.getStringExtra(PLAYER_NAME)
        val numberOfCorrectAnswers = intent.getIntExtra(CORRECT_ANSWERS_NUMBER, 0)
        val numberOfAllQuestions = intent.getIntExtra(NUMBER_OF_ALL_QUESTIONS, 0)

        congratsTextView.text = getString(R.string.Congratulations_text, playerName)
        scoreTextView.text =
            getString(R.string.result_text, numberOfCorrectAnswers, numberOfAllQuestions)
        playAgain.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.playAgain -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}