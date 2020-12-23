package com.example.quiz_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val allQuestions = QuestionConstants.getQuestions()

        val firstQuestion = allQuestions.get(0)
        questionTV.text = firstQuestion.question
        imageIV.setImageResource(firstQuestion.picture)

        firstAnswer.text = firstQuestion.options[0]
        firstAnswer.setOnClickListener{ view ->
            Toast.makeText(view.context, "First answer is chosen", Toast.LENGTH_SHORT).show()
        }

        secondAnswer.text = firstQuestion.options[1]
        secondAnswer.setOnClickListener{ view ->
            Toast.makeText(view.context, "Second answer is chosen", Toast.LENGTH_SHORT).show()
        }

        thirdAnswer.text = firstQuestion.options[2]
        thirdAnswer.setOnClickListener{ view ->
            Toast.makeText(view.context, "Third answer is chosen", Toast.LENGTH_SHORT).show()
        }

        fourthAnswer.text = firstQuestion.options[3]
        fourthAnswer.setOnClickListener{ view ->
            Toast.makeText(view.context, "Fourth answer is chosen", Toast.LENGTH_SHORT).show()
        }

        submitButton.setOnClickListener{ view ->
            Toast.makeText(view.context, "Submit button is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}