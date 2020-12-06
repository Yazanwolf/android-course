package com.example.stupid_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val MINUS_OPERATOR: String = "-"
    val PLUS_OPERATOR: String = "+"
    val MULTIPLICATION_OPERATOR: String = "*"
    val DEVIDE_OPERATOR: String = "/"
    var isOldCalculation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickDigit(view: View) {
        if (isOldCalculation) {
            inputText.text = (view as Button).text
            isOldCalculation = false
            return
        }
        inputText.append((view as Button).text)
    }

    fun onClickOperation(view: View) {
        if (inputText.text.contains("E")) {
            Toast.makeText(view.context, "Result is too big", Toast.LENGTH_LONG).show()
            return
        }
        if (givenNumber.text == "") {
            operationTextView.text = (view as Button).text
            val firstNumber = inputText.text
            if (firstNumber != "") {
                givenNumber.text = firstNumber
                inputText.text = ""
            }
        } else {
            val resultOfFirstOperation = calculate(
                view,
                givenNumber.text.toString(),
                operationTextView.text.toString(),
                inputText.text.toString()
            )
            operationTextView.text = (view as Button).text
            givenNumber.text = resultOfFirstOperation
            inputText.text = ""
        }
    }

    fun onClickEquals(view: View) {
        calculate(
            view,
            givenNumber.text.toString(),
            operationTextView.text.toString(),
            inputText.text.toString()
        )
        operationTextView.text = ""
    }

    fun onClickClear(view: View) {
        clearEverything()
    }

    private fun clearEverything() {
        inputText.text = ""
        givenNumber.text = ""
        operationTextView.text = ""
    }

    fun onClickDecimal(view: View) {
        if (!inputText.text.contains(".") && inputText.text.length < 14) {
            inputText.append(".")
        }
    }

    private fun calculate(view: View, firstNumber: String, operation: String, inputNumber: String)
            : String {

        var result = ""

        when (operation) {
            PLUS_OPERATOR -> {
                result = (firstNumber.toDouble() + inputNumber.toDouble()).toString()
            }
            MINUS_OPERATOR -> {
                result = (firstNumber.toDouble() - inputNumber.toDouble()).toString()
            }
            MULTIPLICATION_OPERATOR -> {
                result = (firstNumber.toDouble() * inputNumber.toDouble()).toString()
            }
            DEVIDE_OPERATOR -> {
                result = (firstNumber.toDouble() / inputNumber.toDouble()).toString()
            }
            else -> Toast.makeText(view.context, "Invalid operation!!!", Toast.LENGTH_SHORT).show()
        }

        isOldCalculation = true

        givenNumber.text = ""

        if (result.contains("E")) {
            Toast.makeText(
                view.context,
                "Result of calculation is very large number!",
                Toast.LENGTH_SHORT
            ).show()

            clearEverything()

            return ""
        }

        inputText.text = result
        return result
    }

}