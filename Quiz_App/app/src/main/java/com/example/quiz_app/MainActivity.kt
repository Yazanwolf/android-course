package com.example.quiz_app

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.quiz_app.Constants.PLAYER_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Todo hide the system ui

        startButton.setOnClickListener{
            if (inputName.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter your name hey!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra(PLAYER_NAME, inputName.text.toString())
            startActivity(intent)
            finish()
        }
    }
}